package dataAccess;

import models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.List;

public class BookAccess {



    private void addBook(String title, String author, Date date, String genre, int count) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            Book book1 = new Book (title, author, date, genre, count);
            session.beginTransaction();
            session.save(book1);
            session.getTransaction().commit();
        }finally{
            factory.close();
        }
    }

    private Book selectBook(int id){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            Book myBook = session.get(Book.class, id);
            session.getTransaction().commit();

            return myBook;

        }
        finally {
            factory.close();
        }

    }

    private void updateBook(int id, int count){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            Book myBook = session.get(Book.class, id);
            myBook.setCount(count);
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

    private void deleteBook(int id){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Book myBook = session.get(Book.class, id);

            session.delete(myBook);

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

    private void queryBook(){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Book> books = session.createQuery("from Book").list();
            displayBooks( books);


            books = session.createQuery("from Book s where s.title='aaa'").list();

            // display the students
            System.out.println("\n\nBooks who have the title of aaa");
            displayBooks(books);


            books = session.createQuery("from Book s where"
                            + " s.title='Daffy' OR s.author='Duck'").list();

            System.out.println("\n\nBooks who have the title of Daffy OR the author Duck");
            displayBooks(books);


            books = session.createQuery("from Book s where"
                    + " s.genre LIKE '%edy'").list();

            System.out.println("\n\nBooks whose genre ends with edy");
            displayBooks(books);


            // commit the transaction
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }
    private static void displayBooks(List<Book> books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        BookAccess b = new BookAccess();
        //b.addBook("vv","aa",null,"comedy",12);
        //b.updateBook(2,1);
    }




}
