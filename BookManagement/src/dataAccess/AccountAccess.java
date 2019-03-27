package dataAccess;

import models.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AccountAccess {

    public void addAccount(String username, String password, String type){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            Account account = new Account(username, password, type);
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    public Account readAccount(int id){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();
            Account account = session.get(Account.class, id);
            session.getTransaction().commit();
            return account;
        }finally {
            factory.close();
        }

    }

    public void updateAccount(int id, String payment){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();
            Account account = session.get(Account.class, id);
            account.setPayment(payment);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    public void deleteAccount(int id){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();
            Account account = session.get(Account.class, id);
            session.delete(account);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    public void queryAccount(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();

            List<Account> accounts = session.createQuery("from Account").list();

            displayAccounts(accounts);


            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    public static void displayAccounts(List<Account> accounts) {
        for (Account b : accounts) {
            System.out.println(b);
        }
    }


    public static void main(String[] args) {
        AccountAccess a = new AccountAccess();
        Account b = new Account();
        //a.addAccount("acc","acc","user");
        //a.queryAccount();
        a.updateAccount(1, "1 month");
        b = a.readAccount(1);
        System.out.println(b.toString());


    }
}
