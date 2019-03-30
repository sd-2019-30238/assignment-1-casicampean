package presentation;

import bussinessLogic.Library;
import bussinessLogic.User;
import dataAccess.AccountAccess;
import dataAccess.BookAccess;
import dataAccess.BorrowedBooksAccess;
import models.Account;
import models.Book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShowBorrowedBooks {

    private JFrame frame;
    private JTextField textField;
    private int userID;
    private Library library;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public ShowBorrowedBooks(int id, Library library){
        this.userID = id;
        this.library = library;
    }

    /**
     * Launch the application.
     */
    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowBorrowedBooks window = new ShowBorrowedBooks();
                    window.initialize();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    public void show(int id, Library library){
        try {
            ShowBorrowedBooks window = new ShowBorrowedBooks(id,library);
            window.initialize();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Create the application.
     */

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 0, 51));
        frame.setBounds(100, 100, 449, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                UserMenu userMenu = new UserMenu(userID,library);
                userMenu.show(userID,library);
            }
        });

        btnBack.setBounds(225, 227, 119, 23);
        frame.getContentPane().add(btnBack);




        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setBounds(100, 71, 244, 109);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setVisible(false);

        JLabel lblUsername = new JLabel("Title:");
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setBounds(37, 42, 39, 14);
        panel.add(lblUsername);

        textField = new JTextField();
        textField.setBounds(76, 39, 137, 20);
        panel.add(textField);
        textField.setColumns(10);


        JLabel lblTryAgain = new JLabel("Incorrect title");
        lblTryAgain.setForeground(new Color(255, 0, 0));
        lblTryAgain.setBounds(76, 14, 106, 14);
        panel.add(lblTryAgain);

        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookAccess bookAccess = new BookAccess();
                AccountAccess accountAccess = new AccountAccess();
                ArrayList<Book>books = bookAccess.queryByTitle(textField.getText());
                if(books.size() > 0){
                    //correct title, so we can return it
                    lblTryAgain.setVisible(false);
                    Account account = accountAccess.readAccount(userID);
                    User user = new User(account.getUsername(),account.getPassword());
                    user.setId(account.getId());
                    Book book = books.get(0);
                    library.validateReturn(user,book);
                    lblTryAgain.setVisible(false);
                    panel.setVisible(false);

                }
                else{
                    lblTryAgain.setVisible(true);
                    textField.setText("");
                }
            }
        });
        btnOk.setBounds(82, 70, 55, 23);
        panel.add(btnOk);




        JButton btnReturnBook = new JButton("Return book");
        btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(true);
                lblTryAgain.setVisible(false);

            }
        });
        btnReturnBook.setBounds(83, 227, 120, 23);
        frame.getContentPane().add(btnReturnBook);

        BorrowedBooksAccess borrowedBooksAccess = new BorrowedBooksAccess();
        ArrayList<String> s = borrowedBooksAccess.getBooksByUser(this.userID);
        System.out.println("id my books:"+this.userID);

        JList list = new JList(s.toArray());
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(47, 43, 335, 159);
        frame.getContentPane().add(scrollPane);
        lblTryAgain.setVisible(false);



    }
}
