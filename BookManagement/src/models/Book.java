package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "release_date")
    private int releaseDate;
    @Column(name = "genre")
    private String genre;
    @Column(name = "count")
    private int count;
    @Column(name = "borrowed_times")
    private int borrowedTimes;


    public Book(String title, String author, int releaseDate, String gendre, int count, int borrowedTimes) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = gendre;
        this.count = count;
        this.borrowedTimes = borrowedTimes;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate +
                ", gendre='" + genre + '\'' +
                ", count=" + count + '\'' +
                ", borrowedTimes=" + borrowedTimes +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (obj == null) return false;
        if (!(obj instanceof Book))
            return false;
        if (obj == this)
            return true;
        return this.getId() == ((Book) obj).getId();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        int result = 1;
        result = 31 * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBorrowedTimes() {
        return borrowedTimes;
    }

    public void setBorrowedTimes(int borrowedTimes) {
        this.borrowedTimes = borrowedTimes;
    }

}
