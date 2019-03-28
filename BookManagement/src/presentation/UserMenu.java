package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UserMenu {

    public JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserMenu window = new UserMenu();
                    window.initialize();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public  void show(){
        try {
            UserMenu window = new UserMenu();
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
        frame.setBounds(100, 100, 300, 340);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnShowAllBooks = new JButton("Show All Books");
        btnShowAllBooks.setBounds(61, 51, 142, 23);
        btnShowAllBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ShowAllBooks showAllBooks = new ShowAllBooks();
                showAllBooks.show();
                frame.setVisible(false);
            }
        });

        frame.getContentPane().add(btnShowAllBooks);

        JButton btnShowMyBooks = new JButton("Show My Books");
        btnShowMyBooks.setBounds(61, 101, 142, 23);
        btnShowMyBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShowBorrowedBooks sh = new ShowBorrowedBooks();
                sh.show();
                frame.setVisible(false);
            }
        });
        frame.getContentPane().add(btnShowMyBooks);

        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(61, 244, 142, 23);
        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        frame.getContentPane().add(btnLogOut);

        JButton btnRecommandations = new JButton("Recommandations");
        btnRecommandations.setBounds(61, 150, 142, 23);
        btnRecommandations.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        frame.getContentPane().add(btnRecommandations);

        JButton btnInsertPreferences = new JButton("Insert preferences");
        btnInsertPreferences.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnInsertPreferences.setBounds(61, 198, 142, 23);
        frame.getContentPane().add(btnInsertPreferences);
    }

}
