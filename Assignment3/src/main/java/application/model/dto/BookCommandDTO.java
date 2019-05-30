package application.model.dto;

public class BookCommandDTO {

    private int release_date;
    private String title;
    private String author;
    private String genre;
    private int count;
    private int borrowed_times;

    public void setRelease_date(int release_date) {
        this.release_date = release_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setBorrowed_times(int borrowed_times) {
        this.borrowed_times = borrowed_times;
    }

    public int getRelease_date() {
        return release_date;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getCount() {
        return count;
    }

    public int getBorrowed_times() {
        return borrowed_times;
    }
}
