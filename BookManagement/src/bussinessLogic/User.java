package bussinessLogic;

import models.Book;

import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private Payment payment;

    public User(int id, String username, String password, Payment payment) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.payment = payment;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    private ArrayList<Book>books;






}
