package application.repository;

import application.model.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Integer> {
}
