package application.controller;

import application.model.Book;
import application.model.dto.BookCommandDTO;
import application.model.dto.BookConverter;
import application.repository.BookRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookCommandController {

    private final BookRepository bookRepository;


    public BookCommandController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/books")
    public void addBook(@RequestBody BookCommandDTO bookCommandDTO){
        Book book = BookConverter.convertDTOtoBook(bookCommandDTO);
        bookRepository.save(book);
    }
}
