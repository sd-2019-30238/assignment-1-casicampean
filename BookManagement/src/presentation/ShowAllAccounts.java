package presentation;

import dataAccess.AccountAccess;
import dataAccess.Reflection;
import models.Account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ShowAllAccounts {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowAllAccounts window = new ShowAllAccounts();
                    window.initialize();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public void show(){
        try {
            ShowAllAccounts window = new ShowAllAccounts();
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
        frame.setBounds(100, 100, 530, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        table = new JTable();
        AccountAccess acc =new AccountAccess();
        ArrayList<Account> ac = acc.queryAccount();
        table = Reflection.retrieveProperties(ac,5);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(36, 22, 442, 193);
        frame.getContentPane().add(scrollPane);



        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                UserMenu acc = new UserMenu();
                acc.show();
            }
        });
        btnBack.setBounds(209, 227, 89, 23);
        frame.getContentPane().add(btnBack);
    }

}
