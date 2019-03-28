package presentation;

import bussinessLogic.Library;
import dataAccess.BookAccess;
import dataAccess.Reflection;
import models.Book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ShowAllBooks {

    private JFrame frame;
    private JTextField textField;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowAllBooks window = new ShowAllBooks();
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
            ShowAllBooks window = new ShowAllBooks();
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
        frame.setForeground(new Color(51, 0, 51));
        frame.getContentPane().setForeground(new Color(51, 0, 51));
        frame.setBounds(100, 100, 597, 316);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnBorrow = new JButton("Borrow");

        btnBorrow.setBounds(190, 243, 89, 23);
        frame.getContentPane().add(btnBorrow);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                UserMenu userMenu =  new UserMenu();
                userMenu.show();
                frame.setVisible(false);
            }
        });
        btnBack.setBounds(304, 243, 89, 23);
        frame.getContentPane().add(btnBack);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setBounds(166, 62, 242, 117);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setForeground(new Color(255, 255, 255));
        lblId.setBounds(56, 18, 24, 14);
        panel.add(lblId);

        JButton btnOk = new JButton("Ok");

        btnOk.setBounds(91, 72, 61, 23);
        panel.add(btnOk);

        textField = new JTextField();
        textField.setBounds(80, 15, 86, 20);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblWrongId = new JLabel("Wrong ID");
        lblWrongId.setForeground(new Color(255, 0, 0));
        lblWrongId.setBounds(100, 46, 86, 14);
        panel.add(lblWrongId);
        lblWrongId.setVisible(false);
        panel.setVisible(false);

        table = new JTable();
        Library library = new Library();
        BookAccess b = new BookAccess();
        ArrayList<Book> books = library.getBooks();
        table = Reflection.retrieveProperties(books, 7);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 13, 561, 219);
        frame.getContentPane().add(scrollPane);


        btnBorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel.setVisible(true);
                textField.setText("");

            }
        });

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookAccess bookAccess = new BookAccess();
                ArrayList<Book>boo = b.getAllBooks();
                ArrayList<Integer>s = new ArrayList<>();

                for(Book bb:boo){
                    s.add(bb.getId());
                }
                //verify the id
                for(Integer i:s){
                    if(i.equals(Integer.parseInt(textField.getText()))){
                        panel.setVisible(false);
                    }
                }
                lblWrongId.setVisible(true);

            }
        });
    }
}
