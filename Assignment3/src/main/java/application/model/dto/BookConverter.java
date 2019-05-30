package application.model.dto;

import application.model.Book;

public class BookConverter {

    public static Book convertDTOtoBook(BookCommandDTO bookCommandDTO) {
        final Book entity = new Book();

        entity.setCount(bookCommandDTO.getCount());
        entity.setBorrowed_times(bookCommandDTO.getBorrowed_times());
        entity.setRelease_date(bookCommandDTO.getRelease_date());
        entity.setAuthor(bookCommandDTO.getAuthor());
        entity.setTitle(bookCommandDTO.getTitle());
        entity.setGenre(bookCommandDTO.getGenre());


        return entity;
    }

    public static BookQueryDTO convertBookToDTO(Book book){

        final BookQueryDTO bookQueryDTO = new BookQueryDTO();

        bookQueryDTO.setAuthor(book.getAuthor());
        bookQueryDTO.setTitle(book.getTitle());
        bookQueryDTO.setBorrowed_times(book.getBorrowed_times());
        bookQueryDTO.setId(book.getId());
        bookQueryDTO.setCount(book.getCount());
        bookQueryDTO.setGenre(book.getGenre());
        bookQueryDTO.setRelease_date(book.getRelease_date());


        return bookQueryDTO;
    }
}
