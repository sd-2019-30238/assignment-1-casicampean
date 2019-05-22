package application.service;


import application.model.BorrowedBooks;
import application.repository.BorrowedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class BorrowedBookService {

    private BorrowedBooksRepository borrowedBooksRepository;

    @Autowired
    public BorrowedBookService(BorrowedBooksRepository borrowedBooksRepository) {
        this.borrowedBooksRepository = borrowedBooksRepository;
    }

    public void addBorrowedBook(int userID, String account, int bookID, String book) {
        BorrowedBooks book1 = new BorrowedBooks(userID, account, bookID, book);
        borrowedBooksRepository.save(book1);
    }

    public List<BorrowedBooks> getBooks(){
        return borrowedBooksRepository.findAll();
    }

    public void printAccounts(){
        List<BorrowedBooks>borrowedBooks = borrowedBooksRepository.findAll();

        for(BorrowedBooks borrowedBook : borrowedBooks){
            System.out.println(borrowedBook);
        }
    }
}
