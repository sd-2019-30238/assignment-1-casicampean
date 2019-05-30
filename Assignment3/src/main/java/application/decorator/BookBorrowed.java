package application.decorator;

import application.model.Book;
import application.repository.BorrowedBooksRepository;

public class BookBorrowed extends BookDecorator{

    private final BorrowedBooksRepository borrowedBooksRepository;


    public BookBorrowed(BorrowedBooksRepository borrowedBooksRepository, Book book) {
        super(book);
        this.borrowedBooksRepository = borrowedBooksRepository;
    }

    @Override
    public String decorate() {

        return super.decorate()+"is borrowed";
    }
}
