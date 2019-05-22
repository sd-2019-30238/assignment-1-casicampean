package application.model;


import javax.persistence.*;

@Entity
@Table(name = "borrowedbooks")
public class BorrowedBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "userID")
    private int userID;
    @Column(name = "username")
    private String username;
    @Column(name = "bookID")
    private int bookID;
    @Column(name = "book")
    private String book;

    public BorrowedBooks(int userID, String username, int bookID, String book) {
        this.userID = userID;
        this.username = username;
        this.bookID = bookID;
        this.book = book;
    }


    public BorrowedBooks() {

    }

    @Override
    public String toString() {
        return "BorrowedBooks{" +
                "id=" + id +
                ", userID=" + userID +
                ", username='" + username + '\'' +
                ", bookID=" + bookID +
                ", book='" + book + '\'' +
                '}';
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
