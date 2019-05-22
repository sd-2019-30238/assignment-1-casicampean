package application.controller;

import application.model.BorrowedBooks;
import application.repository.BorrowedBooksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BorrowedBooksController {

    private final BorrowedBooksRepository borrowedBooksRepository;


    public BorrowedBooksController(BorrowedBooksRepository borrowedBooksRepository) {
        this.borrowedBooksRepository = borrowedBooksRepository;
    }
    @GetMapping("/borrowedBooks")
    public List<BorrowedBooks> getBBooks(){
        return (List<BorrowedBooks>)borrowedBooksRepository.findAll();
    }

    @PostMapping("/borrowedBooks")
    public void addBBook(@RequestBody BorrowedBooks book){
        borrowedBooksRepository.save(book);
    }
}
