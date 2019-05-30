package application.controller;

import application.model.Book;
import application.model.dto.BookConverter;
import application.model.dto.BookQueryDTO;
import application.repository.BookRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookQueryController {

    private final BookRepository bookRepository;


    public BookQueryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<BookQueryDTO> getBooks(){
        List<Book>books = bookRepository.findAll();
        List<BookQueryDTO> bookQueryDTOS = new ArrayList<>();
        for(Book book: books){
            BookQueryDTO bookQueryDTO = BookConverter.convertBookToDTO(book);
            bookQueryDTOS.add(bookQueryDTO);
        }
        return bookQueryDTOS;
    }

}
