package bussinessLogic;

import models.Book;

import java.util.ArrayList;
import java.util.Map;

public class Library {

    private ArrayList<Staff> staff;
    private ArrayList<Book>books;
    private ArrayList<Book>borrowedBooks;
    private Map<Book,ArrayList<User>> waitingList;

    public void filterByReleaseDate(int date){

    }

    public void filterByAuthor(String author){

    }

    public void filterByTitle(String title){

    }

    public void filterByGenre(String genre){

    }
    public void addToBorrowedBooks(Book book){
        borrowedBooks.add(book);
    }
    public void removeFromBorrowedBooks(Book book){
        borrowedBooks.remove(book);
    }
}
