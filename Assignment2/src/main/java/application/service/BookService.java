package application.service;


import application.model.Book;
import application.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title, String author, int date, String genre, int count, int borrowedTimes) {
        Book book = new Book(title, author, date, genre, count, borrowedTimes);
        bookRepository.save(book);
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

    public void updateBook(Integer id, int count, int times){
        Book book = bookRepository.getOne(id);
        book.setCount(count);
        book.setBorrowedTimes(times);
    }

    public void updateBoooooks(Integer id, String title, String author, int date, int count){
        Book book = bookRepository.getOne(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setReleaseDate(date);
        book.setCount(count);
    }

    public Book getBook(Integer id){
        return bookRepository.getOne(id);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void printBooks(){
        List<Book> books = bookRepository.findAll();

        for(Book book : books){
            System.out.println(book);
        }
    }

    /*public List<Book> filterByDate(int date){
        List<Book> books = bookRepository.findAll();
        List<Book> books1 = new ArrayList<>();

        for(Book book : books){
            if(book.getReleaseDate() ==  date){
                books1.add(book);
            }
        }
        return books1;
    }*/

    public List<Book> filterByDate(int date){
        return bookRepository.filterByDate(date);
    }

    public List<Book> filterByTitle(String title){
        return bookRepository.filterByTitle(title);
    }

    public List<Book> getPopularBooks(){
        return bookRepository.getPopularBooks();
    }

}
