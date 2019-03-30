package bussinessLogic;

import dataAccess.AccountAccess;
import dataAccess.BookAccess;
import dataAccess.BorrowedBooksAccess;
import models.Account;
import models.Book;
import models.BorrowedBooks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private ArrayList<Staff> staff;
    private ArrayList<Book>books;
    private ArrayList<Book>borrowedBooks;
    private HashMap<Book,ArrayList<User>> waitingList;
    private BookAccess bookAccess;
    private AccountAccess accountAccess;
    private BorrowedBooksAccess borrowedTable;
    private static int totalSum = 0;

    public Library(){
        this.staff = new ArrayList<>();
        this.books = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
        this.waitingList = new HashMap<>();
        this.bookAccess = new BookAccess();
        this.accountAccess = new AccountAccess();
        this.borrowedTable = new BorrowedBooksAccess();
    }


    public ArrayList<Book> filterByReleaseDate(int date){
        return bookAccess.filterByReleaseDate(date);
    }

    public ArrayList<Book> filterByAuthor(String author){
        return bookAccess.filterByString("author", author);
    }

    public ArrayList<Book> filterByTitle(String title){
        return bookAccess.filterByString("title", title);
    }

    public ArrayList<Book> getBooks(){
        return bookAccess.getAllBooks();
    }

    public ArrayList<BorrowedBooks> getBorrowedHistory(){
        return borrowedTable.selectAll();
    }

    public ArrayList<Book> filterByGenre(String genre){
        return bookAccess.filterByString("genre", genre);
    }

    public void addStaff(Staff s){
        staff.add(s);
    }

    public void addBookToWaitingList(Book book){
        waitingList.put(book, new ArrayList<>());
    }

    public void removeBookFromWaitingList(Book book){
        waitingList.remove(book);
    }

    public void validateBorrow( User user, Book book){
        if(book.getCount() > 0){
            book.setCount(book.getCount() - 1);
            book.setBorrowedTimes(book.getBorrowedTimes() + 1);
            bookAccess.updateBook(book.getId(),book.getCount(),book.getBorrowedTimes());
            borrowedBooks.add(book);
            user.addToBooks(book);
            borrowedTable.addBBook(user.getId(),user.getUsername(),book.getId(), book.getTitle());
        }
        else{
            //add user to waiting list
            //if we don't have a waiting list for a book then we create
            //a new key with that book
            if(!(waitingList.containsKey(book))){
                addBookToWaitingList(book);
                waitingList.get(book).add(user);
            }
            else{
                waitingList.get(book).add(user);
            }
        }
    }
    public void validateReturn(User user, Book book){
        borrowedBooks.remove(book);
        user.removeFromBooks(book);
        book.setCount(book.getCount() + 1);
        bookAccess.updateBook(book.getId(),book.getCount(), book.getBorrowedTimes());
        borrowedTable.deleteByBookId(book.getId());
        if(waitingList.containsKey(book)){
            if(!(waitingList.get(book).isEmpty())) {
                assignNext(book);
            }
            else{
                removeBookFromWaitingList(book);
            }
        }
    }
    public void assignNext(Book book){
        User user = waitingList.get(book).get(0);
        waitingList.get(book).remove(0);
        validateBorrow(user,book);
    }

    public void validatePaymentPlan(User user, String type){
        PaymentPlan payment = new PaymentPlan(type);
        user.setPayment(payment);
        totalSum += payment.getPrice();
        accountAccess.updateAccount(user.getId(),payment.getType());
    }

    public void validateAccount(User user){
        accountAccess.addAccount(user.getUsername(),user.getPassword(),"user");
    }

    public int getUserID(String  username){
        ArrayList<Account>acc = accountAccess.queryRegister(username);
        int id = acc.get(0).getId();
        return id;
    }

    public HashMap<Book, ArrayList<User>> getWaitingList() {
        return waitingList;
    }

    public static void main(String[] args) {
        Library l =new Library();
        BookAccess bbb =new BookAccess();
        Book book = bbb.selectBook(2);
        AccountAccess aaa= new AccountAccess();
        Account user = aaa.readAccount(2);
        User user2 = new User(user.getUsername(),user.getPassword());
        user2.setId(user.getId());

        Account user3 = aaa.readAccount(2);
        User user4 = new User(user3.getUsername(),user3.getPassword());
        user2.setId(user3.getId());
        //l.validateBorrow(user2,book);
        l.validateBorrow(user2,book);
        l.validateReturn(user4, book);
        User u = l.getWaitingList().get(book).get(0);
        System.out.println(u.getUsername());
        System.out.println(l.getWaitingList().containsKey(book));






        //user2.setId(1);
        //user2.createAccount();
        //l.getUserID(user2);
        //System.out.println(l.getUserID(user2.getUsername()));
        //user2.choosePayment("1 month");


        //l.validatePaymentPlan(user2,"6 months");


    }

}
