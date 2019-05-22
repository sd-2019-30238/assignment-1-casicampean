package application.controller;

import application.model.Book;
import application.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    private final BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/books")
    public List<Book> getBooks(){
        return (List<Book>)bookRepository.findAll();
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        bookRepository.save(book);
    }
}
