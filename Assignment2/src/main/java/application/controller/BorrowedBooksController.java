package application.controller;

import application.model.Account;
import application.model.Book;
import application.model.BorrowedBooks;
import application.repository.BookRepository;
import application.repository.BorrowedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BorrowedBooksController {

    private final BorrowedBooksRepository borrowedBooksRepository;
    private final BookRepository bookRepository;

    @Autowired
    private SimpMessagingTemplate template;

    public BorrowedBooksController(BorrowedBooksRepository borrowedBooksRepository, BookRepository bookRepository) {
        this.borrowedBooksRepository = borrowedBooksRepository;
        this.bookRepository = bookRepository;
    }
    @GetMapping("/borrowedBooks")
    public List<BorrowedBooks> getBBooks(){
        return (List<BorrowedBooks>)borrowedBooksRepository.findAll();
    }

    @PostMapping("/borrowedBooks")
    public void addBBook(@RequestBody BorrowedBooks book){

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

    @PostMapping("/getBorrowedBooks")
    public List<BorrowedBooks> getBorrowedBooks(@RequestBody Account account) {
        List<BorrowedBooks> allBorrowedBooks = borrowedBooksRepository.findAll();
        List<BorrowedBooks> borrowedBooks = new ArrayList<>();

        System.out.println(account.getUsername());
        for (BorrowedBooks borrowedBook : allBorrowedBooks) {
            if (borrowedBook.getUsername().equals(account.getUsername())) {
                borrowedBooks.add(borrowedBook);
            }
        }

        System.out.println(borrowedBooks);
        return borrowedBooks;
    }

    @PostMapping("/returnBorrowedBook")
    public void returnBorrowedBooks(@RequestBody BorrowedBooks borrowedBooks) {
        List<BorrowedBooks> allBorrowedBooks = borrowedBooksRepository.findAll();
        Optional<Book> book = bookRepository.findById(borrowedBooks.getBookID());

        if(book.isPresent()){
            book.get().setCount(book.get().getCount() + 1);
        }


        for (BorrowedBooks borrowedBook : allBorrowedBooks) {
            if (borrowedBook.getBookID() == borrowedBooks.getBookID()) {
                if(book.get().getCount() == 1) {
                    template.convertAndSend("/topic/notification/",
                            "Book " + book.get().getTitle() + " is available.");
                }
                borrowedBooksRepository.deleteById(borrowedBook.getId());
                bookRepository.save(book.get());
            }
        }
    }
}
