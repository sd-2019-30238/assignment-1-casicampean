package dataAccess;

import models.Account;
import models.Book;
import models.BorrowedBooks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

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

    public ArrayList<BorrowedBooks> selectAll(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BorrowedBooks.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {

            session.beginTransaction();
            ArrayList<BorrowedBooks> books = (ArrayList<BorrowedBooks>) session.createQuery("from BorrowedBooks").list();
            session.getTransaction().commit();
            return books;
        }finally{
            factory.close();
        }

    }

    public ArrayList<String> getBooksByUser(int id){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BorrowedBooks.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {

            session.beginTransaction();
            ArrayList<String> books = (ArrayList<String>) session.createQuery("select book from BorrowedBooks where userID = "+id).list();
            session.getTransaction().commit();

            return books;
        }finally{
            factory.close();
        }

    }


    public void deleteByBookId(int id){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BorrowedBooks.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {

            session.beginTransaction();
            session.createQuery("delete from BorrowedBooks where bookID="+id).executeUpdate();
            session.getTransaction().commit();

        }finally{
            factory.close();
        }

    }

    public static void main(String[] args) {
        BorrowedBooksAccess b = new BorrowedBooksAccess();
        b.addBBook(1,"aa",2,"ccc");
        //b.addBook("vv","aa",null,"comedy",12);
        //b.updateBook(2,1);
        //ArrayList<String> s = b.getBooksByUser("aa");
        /*for(String ss:s){
            System.out.println(ss);
        }*/

        BorrowedBooksAccess borrowedBooksAccess = new BorrowedBooksAccess();
        borrowedBooksAccess.deleteByBookId(4);

    }


}
