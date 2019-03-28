package presentation;

import dataAccess.BorrowedBooksAccess;

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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
    }

    public void show(){
        try {
            ShowBorrowedBooks window = new ShowBorrowedBooks();
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
                UserMenu userMenu = new UserMenu();
                userMenu.show();
            }
        });

        btnBack.setBounds(164, 227, 89, 23);
        frame.getContentPane().add(btnBack);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setBounds(100, 71, 244, 109);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setBounds(0, 42, 85, 14);
        panel.add(lblUsername);

        textField = new JTextField();
        textField.setBounds(72, 39, 151, 20);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblTryAgain = new JLabel("Try again");
        lblTryAgain.setForeground(new Color(255, 0, 0));
        lblTryAgain.setBounds(76, 14, 106, 14);
        panel.add(lblTryAgain);
        lblTryAgain.setVisible(false);

        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                BorrowedBooksAccess borrowedBooksAccess = new BorrowedBooksAccess();
                ArrayList<String> s = borrowedBooksAccess.getBooksByUser(textField.getText());
                if( s.size() > 0){

                    JList list = new JList(s.toArray());
                    JScrollPane scrollPane = new JScrollPane(list);
                    scrollPane.setBounds(47, 43, 335, 159);
                    frame.getContentPane().add(scrollPane);
                    lblTryAgain.setVisible(false);
                    panel.setVisible(false);
                }
                else{
                    lblTryAgain.setVisible(true);
                    textField.setText("");
                    JList list = new JList();
                    list.setListData(new String[0]);
                }

            }
        });
        btnOk.setBounds(82, 70, 55, 23);
        panel.add(btnOk);



        /*JList list = new JList();

        BorrowedBooksAccess borrowedBooksAccess = new BorrowedBooksAccess();
        ArrayList<String> s = borrowedBooksAccess.getBooksByUser(textField.getText());

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(47, 43, 335, 159);
        frame.getContentPane().add(scrollPane);
        */

    }
}
