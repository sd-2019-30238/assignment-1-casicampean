package application.model.dto;

public class BorrowedCommandDTO {

    private int id;
    private int userID;
    private String username;
    private int bookID;
    private String book;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBook() {
        return book;
    }
}
