package application.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "release_date")
    private int release_date;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "genre")
    private String genre;
    @Column(name = "count")
    private int count;
    @Column(name = "borrowed_times")
    private int borrowed_times;


    public Book(String title, String author, int release_date, String gedre, int count, int borrowed_times) {
        this.title = title;
        this.author = author;
        this.release_date = release_date;
        this.genre = gedre;
        this.count = count;
        this.borrowed_times = borrowed_times;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", release_date=" + release_date +
                ", genre='" + genre + '\'' +
                ", count=" + count + '\'' +
                ", borrowed_times=" + borrowed_times +
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRelease_date() {
        return release_date;
    }

    public void setRelease_date(int release_date) {
        this.release_date = release_date;
    }

    public int getBorrowed_times() {
        return borrowed_times;
    }

    public void setBorrowed_times(int borrowed_times) {
        this.borrowed_times = borrowed_times;
    }
}
