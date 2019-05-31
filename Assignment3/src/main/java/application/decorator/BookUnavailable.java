package application.decorator;

import application.model.Book;

public class BookUnavailable extends  BookDecorator {
    private Book book;

    public BookUnavailable(Book book) {
        super(book);
    }

    @Override
    public String decorate() {
        if(this.book.getCount() < 0)
            return super.decorate()+"unavailable";
        else
            return super.decorate()+"available";
    }
}
