package dataAccess;

import models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookAccess {


    public void addBook(String title, String author, int date, String genre, int count, int borrowedTimes) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            Book book1 = new Book(title, author, date, genre, count, borrowedTimes);
            session.beginTransaction();
            session.save(book1);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    public Book selectBook(int id) {
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

        } finally {
            factory.close();
        }

    }

    public void updateBook(int id, int count, int times) {
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
            myBook.setBorrowedTimes(times);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }

    public void updateBooks(int id, String title, String author, int date, int count) {
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
            myBook.setTitle(title);
            myBook.setAuthor(author);
            myBook.setReleaseDate(date);
            myBook.setCount(count);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }


    public void deleteBook(int id) {
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

        } finally {
            factory.close();
        }

    }

    public ArrayList<Book> filterByReleaseDate(int date) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            String s = "from Book s where s.releaseDate=" + date;

            ArrayList<Book> books = (ArrayList<Book>) session.createQuery(s).list();
            displayBooks(books);
            session.getTransaction().commit();

            return books;

        } finally {
            factory.close();
        }
    }

    public ArrayList<Book> filterByString(String column, String string) {
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

            switch (column) {
                case "author":
                    s = "from Book s where s.author=" + "'" + string + "'";
                    break;
                case "title":
                    s = "from Book s where s.title=" + "'" + string + "'";
                    break;
                case "genre":
                    s = "from Book s where s.genre=" + "'" + string + "'";
                    break;
            }

            ArrayList<Book> books = (ArrayList<Book>) session.createQuery(s).list();
            session.getTransaction().commit();

            return books;

        } finally {
            factory.close();
        }
    }

    public ArrayList<Book> getAllBooks() {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            ArrayList<Book> books = (ArrayList<Book>) session.createQuery("from Book").list();
            // displayBooks(books);
            session.getTransaction().commit();

            return books;

        } finally {
            factory.close();
        }
    }

    public ArrayList<Book> getBooksByPopularity() {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            ArrayList<Book> books = (ArrayList<Book>) session.createQuery("from Book s where s.borrowedTimes > 3").list();
            // displayBooks(books);
            session.getTransaction().commit();

            return books;

        } finally {
            factory.close();
        }
    }

    public int queryByID(int id) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            String s = "from Book s where s.id=" + id;
            session.beginTransaction();
            ArrayList<Book> books = (ArrayList<Book>) session.createQuery(s).list();
            // displayBooks(books);
            session.getTransaction().commit();

            return books.size();

        } finally {
            factory.close();
        }
    }

    public ArrayList<Book> queryByTitle(String title) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            String s = "from Book s where s.title= '" + title + "'";
            session.beginTransaction();
            ArrayList<Book> books = (ArrayList<Book>) session.createQuery(s).list();
            // displayBooks(books);
            session.getTransaction().commit();

            return books;

        } finally {
            factory.close();
        }
    }


    public static void displayBooks(ArrayList<Book> books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        BookAccess b = new BookAccess();
        //b.addBook("vv","aa",null,"comedy",12);
        //b.updateBook(2,1);
        // b.getAllBooks();
        ArrayList<Book> boo = b.getBooksByPopularity();

        System.out.println(boo.size());
        Book book = boo.get(0);
        System.out.println(book.getId() + " " + book.getTitle());


        //displayBooks(boo);


    }


}
