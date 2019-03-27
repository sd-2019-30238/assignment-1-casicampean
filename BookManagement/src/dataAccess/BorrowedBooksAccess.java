package dataAccess;

import models.Account;
import models.Book;
import models.BorrowedBooks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BorrowedBooksAccess {

    public void addBBook(int userID, String account, int bookID, String book){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BorrowedBooks.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            BorrowedBooks book1 = new BorrowedBooks(userID, account, bookID, book);
            session.beginTransaction();
            session.save(book1);
            session.getTransaction().commit();
        }finally{
            factory.close();
        }
    }

    public BorrowedBooks selectBBook(int id){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BorrowedBooks.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            BorrowedBooks myBook = session.get(BorrowedBooks.class, id);
            session.getTransaction().commit();

            return myBook;

        }
        finally {
            factory.close();
        }

    }
    public void deleteBBook(int id){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BorrowedBooks.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            BorrowedBooks myBook = session.get(BorrowedBooks.class, id);
            session.delete(myBook);
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

    public static void main(String[] args) {
        BorrowedBooksAccess b = new BorrowedBooksAccess();
        b.addBBook(1,"aa",2,"ccc");
        //b.addBook("vv","aa",null,"comedy",12);
        //b.updateBook(2,1);
    }

}
