package models;

import javax.persistence.*;


@Entity
@Table
public class BorrowedBooks {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column (name = "userID")
    private int userID;
    @Column(name = "username")
    private String account;
    @Column (name = "bookID")
    private int bookID;
    @Column(name = "book")
    private String book;

    public BorrowedBooks(int userID, String account, int bookID, String book) {
        this.userID = userID;
        this.account = account;
        this.bookID = bookID;
        this.book = book;
    }

    public BorrowedBooks(){

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }




}
