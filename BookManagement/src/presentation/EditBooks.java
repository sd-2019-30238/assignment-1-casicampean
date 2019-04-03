package presentation;


import bussinessLogic.Library;
import dataAccess.BookAccess;
import dataAccess.Reflection;
import models.Book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class EditBooks {

    private JFrame frame;
    private JTable table;
    private JTextField textField;
    private JTextField textField_Title;
    private JTextField textField_Author;
    private JTextField textField_Date;
    private JTextField textField_Genre;
    private JTextField textField_Count;
    private int ok =0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditBooks window = new EditBooks();
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
            EditBooks window = new EditBooks();
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
        frame.setBackground(new Color(0, 0, 51));
        frame.setBounds(100, 100, 552, 364);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblIncorrect = new JLabel("Incorrect");
        lblIncorrect.setForeground(Color.RED);
        lblIncorrect.setBounds(320, 297, 67, 14);
        frame.getContentPane().add(lblIncorrect);
        lblIncorrect.setVisible(false);

        table = new JTable();
        Library library = new Library();
        ArrayList<Book> books = library.getBooks();
        table = Reflection.retrieveProperties(books, 7);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 516, 155);
        frame.getContentPane().add(scrollPane);

        BookAccess bookAccess = new BookAccess();

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ArrayList<Book> booksByTitle = bookAccess.queryByTitle(textField_Title.getText());
                if(booksByTitle.size() > 0){
                    lblIncorrect.setVisible(true);
                    textField.setText("");
                    textField_Author.setText("");
                    textField_Count.setText("");
                    textField_Genre.setText("");
                    textField_Date.setText("");
                    textField_Title.setText("");

                }
                else{
                    int date = Integer.parseInt(textField_Date.getText());
                    int count = Integer.parseInt(textField_Count.getText());
                    bookAccess.addBook(textField_Title.getText(),textField_Author.getText(),date,textField_Genre.getText(),count,0);
                    lblIncorrect.setVisible(false);
                    textField.setText("");
                    textField_Author.setText("");
                    textField_Count.setText("");
                    textField_Genre.setText("");
                    textField_Date.setText("");
                    textField_Title.setText("");
                }


            }
        });
        btnAdd.setBounds(23, 184, 89, 23);
        frame.getContentPane().add(btnAdd);




        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nrBooks = bookAccess.queryByID(Integer.parseInt(textField.getText()));
                if(nrBooks > 0){
                    bookAccess.deleteBook(Integer.parseInt(textField.getText()));
                    lblIncorrect.setVisible(false);
                }
                else{
                    lblIncorrect.setVisible(true);

                }

            }
        });
        btnDelete.setBounds(122, 184, 89, 23);
        frame.getContentPane().add(btnDelete);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nrBooks = bookAccess.queryByID(Integer.parseInt(textField.getText()));
                if(nrBooks > 0){
                    lblIncorrect.setVisible(false);
                    Book book = bookAccess.selectBook(Integer.parseInt(textField.getText()));
                    if(!(textField_Title.equals(""))){
                        book.setTitle(textField_Title.getText());
                    }
                    if(!(textField_Author.equals(""))){
                        book.setAuthor(textField_Author.getText());
                    }
                    if(!(textField_Date.equals(null))){
                        book.setReleaseDate(Integer.parseInt(textField_Date.getText()));
                    }
                    if(!textField_Count.equals("")){
                        book.setCount(Integer.parseInt(textField_Count.getText()));
                    }
                    bookAccess.updateBooks( Integer.parseInt(textField.getText()),book.getTitle(),book.getAuthor(),book.getReleaseDate(),book.getCount());

                }
                else{
                    lblIncorrect.setVisible(true);
                }
            }
        });
        btnUpdate.setBounds(221, 184, 89, 23);
        frame.getContentPane().add(btnUpdate);

        textField = new JTextField();
        textField.setBounds(68, 230, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblId = new JLabel("Id:");
        lblId.setForeground(new Color(255, 255, 255));
        lblId.setBounds(34, 233, 31, 14);
        frame.getContentPane().add(lblId);

        textField_Title = new JTextField();
        textField_Title.setBounds(68, 261, 86, 20);
        frame.getContentPane().add(textField_Title);
        textField_Title.setColumns(10);

        JLabel lblTitle = new JLabel("Title:");
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setBounds(28, 264, 37, 14);
        frame.getContentPane().add(lblTitle);

        textField_Author = new JTextField();
        textField_Author.setBounds(68, 294, 86, 20);
        frame.getContentPane().add(textField_Author);
        textField_Author.setColumns(10);

        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setForeground(new Color(255, 255, 255));
        lblAuthor.setBounds(19, 297, 46, 14);
        frame.getContentPane().add(lblAuthor);

        textField_Date = new JTextField();
        textField_Date.setBounds(224, 230, 86, 20);
        frame.getContentPane().add(textField_Date);
        textField_Date.setColumns(10);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setForeground(new Color(255, 255, 255));
        lblDate.setBounds(179, 233, 37, 14);
        frame.getContentPane().add(lblDate);

        textField_Genre = new JTextField();
        textField_Genre.setBounds(224, 261, 86, 20);
        frame.getContentPane().add(textField_Genre);
        textField_Genre.setColumns(10);

        JLabel lblGenre = new JLabel("Genre:");
        lblGenre.setForeground(new Color(255, 255, 255));
        lblGenre.setBounds(179, 264, 35, 14);
        frame.getContentPane().add(lblGenre);

        textField_Count = new JTextField();
        textField_Count.setBounds(224, 294, 86, 20);
        frame.getContentPane().add(textField_Count);
        textField_Count.setColumns(10);

        JLabel lblCount = new JLabel("Count:");
        lblCount.setForeground(new Color(255, 255, 255));
        lblCount.setBounds(177, 297, 37, 14);
        frame.getContentPane().add(lblCount);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StaffMenu sh = new StaffMenu();
                sh.show();
            }
        });
        btnBack.setBounds(425, 291, 89, 23);
        frame.getContentPane().add(btnBack);
    }
}
