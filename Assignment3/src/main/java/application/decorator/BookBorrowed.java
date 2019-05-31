package application.decorator;

import application.model.Book;
import application.model.BorrowedBook;
import application.repository.BorrowedBooksRepository;

import java.util.List;

public class BookBorrowed extends BookDecorator{

    private Book book;

    private final BorrowedBooksRepository borrowedBooksRepository;


    public BookBorrowed(BorrowedBooksRepository borrowedBooksRepository, Book book) {
        super(book);
        this.borrowedBooksRepository = borrowedBooksRepository;
    }

    @Override
    public String decorate() {
        List<BorrowedBook> borrowedBookList=borrowedBooksRepository.findAll();
        for(BorrowedBook borrowedBook: borrowedBookList){
            if(borrowedBook.getBook().equals(this.book.getTitle()))
                return super.decorate()+"is borrowed";
            else
                return super.decorate()+"is not borrowed";
        }
        return "";
    }
}
