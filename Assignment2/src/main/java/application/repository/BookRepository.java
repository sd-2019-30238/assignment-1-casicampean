package application.repository;

import application.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

   @Query("SELECT b FROM Book b where b.release_date = :release_date")
    public List<Book> filterByDate(@Param("release_date") Integer release_date);

    @Query("SELECT b FROM Book b where b.author = :author")
    public List<Book> filterByAuthor(@Param("author") String author);

    @Query("SELECT b FROM Book b where b.genre = :genre")
    public List<Book> filterByGenre(@Param("genre") String genre);

    @Query("SELECT b FROM Book b where b.title = :title")
    public List<Book> filterByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b where b.count > 4 ")
    public List<Book> getPopularBooks();
}
