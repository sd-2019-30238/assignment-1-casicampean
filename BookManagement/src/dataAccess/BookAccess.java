package dataAccess;

import models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.List;

public class BookAccess {



    private void addBook(String title, String author, int date, String genre, int count, int borrowedTimes) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            Book book1 = new Book (title, author, date, genre, count,borrowedTimes);
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

    private void filterByReleaseDate(int date) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            String s = "from Book s where s.releaseDate="+date;

            List<Book> books = session.createQuery(s).list();
            displayBooks(books);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

    private void filterByString(String column, String string) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            String s = "";

            switch (column){
                case "author": s = "from Book s where s.author="+"'"+string+"'"; break;
                case "title": s = "from Book s where s.title="+"'"+string+"'"; break;
                case "genre": s = "from Book s where s.genre="+"'"+string+"'"; break;
            }


            List<Book> books = session.createQuery(s).list();
            displayBooks(books);
            session.getTransaction().commit();

        } finally {
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
        b.filterByReleaseDate(0);
    }




}
