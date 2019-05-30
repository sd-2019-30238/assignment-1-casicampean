package application.model.dto;

import application.model.BorrowedBook;

public class BorrowedConverter {

    public static BorrowedBook convertDTOtoBorrowed(BorrowedCommandDTO borrowedCommandDTO) {
        final BorrowedBook entity = new BorrowedBook();

        entity.setBook(borrowedCommandDTO.getBook());
        entity.setBookID(borrowedCommandDTO.getBookID());
        entity.setUsername(borrowedCommandDTO.getUsername());
        entity.setUserID(borrowedCommandDTO.getUserID());

        return entity;
    }

    public static BorrowedQueryDTO convertBorrowedToDTO(BorrowedBook borrowedBook){

        final BorrowedQueryDTO borrowedQueryDTO = new BorrowedQueryDTO();

        borrowedQueryDTO.setBook(borrowedBook.getBook());
        borrowedQueryDTO.setBookID(borrowedBook.getBookID());
        borrowedQueryDTO.setUsername(borrowedBook.getUsername());
        borrowedQueryDTO.setId(borrowedBook.getId());
        borrowedQueryDTO.setUserID(borrowedBook.getUserID());


        return borrowedQueryDTO;
    }
}
