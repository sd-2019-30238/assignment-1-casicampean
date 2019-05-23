package application.model;


import application.observer.Observer;
import application.observer.Subject;

import javax.persistence.*;

@Entity
//@Table
public class Account implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String type;
    private String payment;
    @Transient
    private int availableBooks;
    @Transient
    private static int observerIDTracker = 0;
    @Transient
    private int observerID;
    @Transient
    private Subject book;




    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }


    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Account() {

    }

    public Account(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.observerID = ++observerIDTracker;
        System.out.println("New Observer " + this.observerID);
        book.register(this);

    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayment() {
        return payment;
    }

    @Override
    public void update(int availableBook) {
        this.availableBooks = availableBook;
        printCount();

    }

    public void printCount(){
        System.out.println(observerID+" "+ availableBooks);
    }
}
