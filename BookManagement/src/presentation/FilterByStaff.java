package presentation;

import bussinessLogic.Staff;
import dataAccess.BookAccess;
import dataAccess.Reflection;
import models.Book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FilterByStaff {

    private JFrame frame;
    private JTable table;
    private JTextField textField;

    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public void show() {
        try {
            FilterByStaff window = new FilterByStaff();
            window.initialize();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 0, 51));
        frame.setBounds(100, 100, 557, 328);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(167, 252, 223, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblDateauthortitlegenre = new JLabel("Date/Author/Title/Genre:");
        lblDateauthortitlegenre.setForeground(Color.WHITE);
        lblDateauthortitlegenre.setBounds(17, 255, 140, 14);
        frame.getContentPane().add(lblDateauthortitlegenre);

        JLabel lblIncorrectdoesntExists = new JLabel("Incorrect/Doesn't exists");
        lblIncorrectdoesntExists.setForeground(Color.RED);
        lblIncorrectdoesntExists.setBounds(172, 234, 140, 14);
        frame.getContentPane().add(lblIncorrectdoesntExists);
        lblIncorrectdoesntExists.setVisible(false);


        table = new JTable();


        BookAccess bookAccess = new BookAccess();
        ArrayList<Book> books = bookAccess.getAllBooks();
        table = Reflection.retrieveProperties(books, 7);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 521, 163);
        frame.getContentPane().add(scrollPane);

        JButton btnByReleaseDate = new JButton("By Release Date");
        btnByReleaseDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Book> books = bookAccess.filterByReleaseDate(Integer.parseInt(textField.getText()));
                if (books.size() > 0) {
                    lblIncorrectdoesntExists.setVisible(false);
                    table = Reflection.retrieveProperties(books, 7);
                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBounds(10, 11, 521, 163);
                    frame.getContentPane().add(scrollPane);
                } else {
                    lblIncorrectdoesntExists.setVisible(true);
                    textField.setText("");
                }
            }
        });
        btnByReleaseDate.setBounds(39, 200, 111, 23);
        frame.getContentPane().add(btnByReleaseDate);

        JButton btnByAuthor = new JButton("By Author");
        btnByAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArrayList<Book> books = bookAccess.filterByString("author", textField.getText());
                if (books.size() > 0) {
                    lblIncorrectdoesntExists.setVisible(false);
                    table = Reflection.retrieveProperties(books, 7);
                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBounds(10, 11, 521, 163);
                    frame.getContentPane().add(scrollPane);
                } else {
                    lblIncorrectdoesntExists.setVisible(true);
                    textField.setText("");
                }
            }

        });
        btnByAuthor.setBounds(174, 200, 99, 23);
        frame.getContentPane().add(btnByAuthor);

        JButton btnByTitle = new JButton("By Title");
        btnByTitle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArrayList<Book> books = bookAccess.filterByString("title", textField.getText());
                if (books.size() > 0) {
                    lblIncorrectdoesntExists.setVisible(false);
                    table = Reflection.retrieveProperties(books, 7);
                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBounds(10, 11, 521, 163);
                    frame.getContentPane().add(scrollPane);
                } else {
                    lblIncorrectdoesntExists.setVisible(true);
                    textField.setText("");
                }
            }
        });
        btnByTitle.setBounds(291, 200, 99, 23);
        frame.getContentPane().add(btnByTitle);

        JButton btnByGendre = new JButton("By gendre");
        btnByGendre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArrayList<Book> books = bookAccess.filterByString("genre", textField.getText());
                if (books.size() > 0) {
                    lblIncorrectdoesntExists.setVisible(false);
                    table = Reflection.retrieveProperties(books, 7);
                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBounds(10, 11, 521, 163);
                    frame.getContentPane().add(scrollPane);
                } else {
                    lblIncorrectdoesntExists.setVisible(true);
                    textField.setText("");
                }
            }
        });
        btnByGendre.setBounds(413, 200, 99, 23);
        frame.getContentPane().add(btnByGendre);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StaffMenu staffMenu = new StaffMenu();
                staffMenu.show();
            }
        });
        btnBack.setBounds(423, 251, 89, 23);
        frame.getContentPane().add(btnBack);


    }

}
