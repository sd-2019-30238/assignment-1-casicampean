package presentation;

import bussinessLogic.Library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UserMenu {

    public JFrame frame;
    private int userID;
    private Library library;

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public UserMenu(int id, Library library){
        this.userID = id;
        this.library = library;
    }

    public  void show(int id, Library library){
        try {
            UserMenu window = new UserMenu(id, library);
            window.initialize();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 0, 51));
        frame.setBounds(100, 100, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnShowAllBooks = new JButton("Show All Books");
        btnShowAllBooks.setBounds(61, 51, 142, 23);
        btnShowAllBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ShowAllBooks showAllBooks = new ShowAllBooks(userID,library);
                showAllBooks.show(userID, library);
                frame.setVisible(false);
            }
        });

        frame.getContentPane().add(btnShowAllBooks);

        JButton btnShowMyBooks = new JButton("Show My Books");
        btnShowMyBooks.setBounds(61, 101, 142, 23);
        btnShowMyBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShowBorrowedBooks sh = new ShowBorrowedBooks(getUserID(), library);
                sh.show(getUserID(), library);
                System.out.println("user menu"+getUserID());
                frame.setVisible(false);
            }
        });
        frame.getContentPane().add(btnShowMyBooks);

        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(61, 198, 142, 23);
        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShowLogin lg = new ShowLogin(library);
                frame.setVisible(true);
                lg.show(library);
            }
        });
        frame.getContentPane().add(btnLogOut);

        JButton btnRecommendations = new JButton("Recommendations");
        btnRecommendations.setBounds(61, 150, 142, 23);
        btnRecommendations.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ShowRecommendations sh = new ShowRecommendations(userID,library);
                sh.show(userID,library);
            }
        });
        frame.getContentPane().add(btnRecommendations);


    }

}
