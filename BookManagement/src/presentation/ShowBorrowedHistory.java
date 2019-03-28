package presentation;

import bussinessLogic.Library;
import dataAccess.Reflection;
import models.BorrowedBooks;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;

public class ShowBorrowedHistory {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowBorrowedHistory window = new ShowBorrowedHistory();
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
            ShowBorrowedHistory window = new ShowBorrowedHistory();
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
        frame.setBounds(100, 100, 497, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        table = new JTable();
        Library library = new Library();
        ArrayList<BorrowedBooks> b = library.getBorrowedHistory();
        table = Reflection.retrieveProperties(b,5);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 461, 203);
        frame.getContentPane().add(scrollPane);




        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StaffMenu s =new StaffMenu();
                s.show();
            }
        });
        btnBack.setBounds(208, 227, 89, 23);
        frame.getContentPane().add(btnBack);
    }

}
