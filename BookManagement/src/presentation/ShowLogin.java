package presentation;

import bussinessLogic.Library;
import bussinessLogic.User;
import dataAccess.AccountAccess;
import models.Account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;

public class ShowLogin {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowLogin window = new ShowLogin();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void show(){
        try {
            ShowLogin window = new ShowLogin();
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
        frame.setBounds(100, 100, 450, 327);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(146, 45, 177, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setBounds(75, 48, 65, 14);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBounds(75, 106, 65, 14);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(146, 103, 177, 20);
        frame.getContentPane().add(passwordField);

        JLabel lblInvalidLoginPlease = new JLabel("Invalid login, please try again");
        lblInvalidLoginPlease.setForeground(new Color(204, 0, 0));
        lblInvalidLoginPlease.setBounds(156, 134, 210, 14);
        frame.getContentPane().add(lblInvalidLoginPlease);
        lblInvalidLoginPlease.setVisible(false);

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ShowRegister sh = new ShowRegister();
                sh.show();
            }
        });
        btnRegister.setBounds(184, 198, 89, 23);
        frame.getContentPane().add(btnRegister);



        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AccountAccess accountAccess = new AccountAccess();
                Library l =new Library();
                User user = new User(textField.getText(),passwordField.getToolTipText());
                ArrayList<Account>accounts = accountAccess.queryLogin(textField.getText(), passwordField.getToolTipText());
                if(accounts.size() > 0){
                    lblInvalidLoginPlease.setVisible(true);

                }
                else{
                    lblInvalidLoginPlease.setVisible(false);
                    user.createAccount();
                    UserMenu userMenu = new UserMenu();
                    userMenu.show();
                    frame.setVisible(false);


                }
            }
        });
        btnLogin.setBounds(184, 164, 89, 23);
        frame.getContentPane().add(btnLogin);

        JButton btnStaff = new JButton("Staff");
        btnStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnStaff.setBounds(184, 233, 89, 23);
        frame.getContentPane().add(btnStaff);




    }
    public User getUser(){
        User user = new User(textField.getText(),passwordField.getToolTipText());
        return user;
    }
}
