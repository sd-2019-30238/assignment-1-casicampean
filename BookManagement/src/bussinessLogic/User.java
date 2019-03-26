package bussinessLogic;

import models.Account;
import models.Book;

import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private PaymentPlan paymentPlan;
    private Account acount;
    private ArrayList<Book>books;



    public User(int id, String username, String password, PaymentPlan payment) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.paymentPlan = payment;
    }

    public void borrowBook(){

    }

    public void returnBook(){

    }

    public void createAccount(){

    }

    public void choosePayment(){

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



    public PaymentPlan getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(PaymentPlan paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public Account getAcount() {
        return acount;
    }

    public void setAcount(Account acount) {
        this.acount = acount;
    }


}
