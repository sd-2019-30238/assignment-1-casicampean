package bussinessLogic;

import models.Account;
import models.Book;
import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private PaymentPlan paymentPlan;
    private Account account;
    private ArrayList<Book>books;
    private Library library;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.books = new ArrayList<>();
        this.library = new Library();
    }
    public User(){}

    public void borrowBook(Book book){
        library.validateBorrow(this, book);
    }

    public void removeFromBooks(Book book){
        books.remove(book);
    }
    public void addToBooks(Book book){
        books.add(book);
    }

    public void returnBook(Book book){
        library.validateReturn(this, book);
    }

    public void createAccount(){
        library.validateAccount(this);



    }

    public void choosePayment(String type){
        library.validatePaymentPlan(this, type);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PaymentPlan getPayment() {
        return paymentPlan;
    }

    public void setPayment(PaymentPlan payment) {
        this.paymentPlan = payment;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }





    public Account getAcount() {
        return account;
    }

    public void setAcount(Account acount) {
        this.account = acount;
    }


}
