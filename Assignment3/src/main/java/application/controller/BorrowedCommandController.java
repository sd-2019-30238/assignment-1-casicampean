package application.controller;

import application.model.Book;
import application.model.BorrowedBook;
import application.repository.BookRepository;
import application.repository.BorrowedBooksRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BorrowedCommandController {

    private final BorrowedBooksRepository borrowedBooksRepository;
    private final BookRepository bookRepository;


    public BorrowedCommandController(BorrowedBooksRepository borrowedBooksRepository, BookRepository bookRepository) {
        this.borrowedBooksRepository = borrowedBooksRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/borrowedBooks")
    public void addBBook(@RequestBody BorrowedBook book){

        Optional<Book> newBook = bookRepository.findById(book.getBookID());
        if(newBook.get().getCount()>0) {
            newBook.get().setCount(newBook.get().getCount() - 1);
        }
        bookRepository.save(newBook.get());

        book.setBook(newBook.get().getTitle());

        if (newBook.isPresent() && newBook.get().getCount() > 0) {
            borrowedBooksRepository.save(book);
        }
    }

    @PostMapping("/returnBorrowedBook")
    public void returnBorrowedBooks(@RequestBody BorrowedBook borrowedBooks) {
        List<BorrowedBook> allBorrowedBooks = borrowedBooksRepository.findAll();
        Optional<Book> book = bookRepository.findById(borrowedBooks.getBookID());

        if(book.isPresent()){
            book.get().setCount(book.get().getCount() + 1);
        }


        for (BorrowedBook borrowedBook : allBorrowedBooks) {
            if (borrowedBook.getBookID() == borrowedBooks.getBookID()) {
                borrowedBooksRepository.deleteById(borrowedBook.getId());
                bookRepository.save(book.get());
            }
        }
    }
}
