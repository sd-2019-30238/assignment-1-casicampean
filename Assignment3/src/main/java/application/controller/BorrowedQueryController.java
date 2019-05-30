package application.controller;

import application.model.Account;
import application.model.BorrowedBook;
import application.model.dto.BorrowedConverter;
import application.model.dto.BorrowedQueryDTO;
import application.repository.BookRepository;
import application.repository.BorrowedBooksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BorrowedQueryController {

    private final BorrowedBooksRepository borrowedBooksRepository;
    private final BookRepository bookRepository;


    public BorrowedQueryController(BorrowedBooksRepository borrowedBooksRepository, BookRepository bookRepository) {
        this.borrowedBooksRepository = borrowedBooksRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/borrowedBooks")
    public List<BorrowedQueryDTO> getBBooks(){
        List<BorrowedBook>borrowedBooks =  borrowedBooksRepository.findAll();
        List<BorrowedQueryDTO>borrowedQueryDTOS  = new ArrayList<>();
        for(BorrowedBook borrowedBook: borrowedBooks){
            BorrowedQueryDTO borrowedQueryDTO = BorrowedConverter.convertBorrowedToDTO(borrowedBook);
            borrowedQueryDTOS.add(borrowedQueryDTO);
        }
        return borrowedQueryDTOS;
    }

    @PostMapping("/getBorrowedBooks")
    public List<BorrowedQueryDTO> getBorrowedBooks(@RequestBody Account account) {
        List<BorrowedBook> allBorrowedBooks = borrowedBooksRepository.findAll();
        List<BorrowedBook> borrowedBooks = new ArrayList<>();
        List<BorrowedQueryDTO> borrowedQueryDTOS = new ArrayList<>();

        System.out.println(account.getUsername());
        for (BorrowedBook borrowedBook : allBorrowedBooks) {
            if (borrowedBook.getUsername().equals(account.getUsername())) {
                borrowedBooks.add(borrowedBook);
            }
        }

        for(BorrowedBook borrowedBook: borrowedBooks){
            BorrowedQueryDTO borrowedQueryDTO = BorrowedConverter.convertBorrowedToDTO(borrowedBook);
            borrowedQueryDTOS.add(borrowedQueryDTO);
        }


        System.out.println(borrowedBooks);
        return borrowedQueryDTOS;
    }
}
