package application.decorator;

import application.model.Book;

public abstract class BookDecorator implements Ownership{
    private Book book;

    public BookDecorator(Book book) {
        this.book = book;
    }

    @Override
    public String decorate() {
        return book.decorate();
    }
}
