package presentation;


import bussinessLogic.Library;
import bussinessLogic.Staff;
import bussinessLogic.User;
import dataAccess.AccountAccess;
import models.Account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowRegister {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private Library library;
    private int userID;

    /**
     * Launch the application.
     */


    public void show(Library library) {
        try {
            ShowRegister window = new ShowRegister(library);
            window.initialize();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ShowRegister(Library library) {
        this.library = library;
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
        frame.setBounds(100, 100, 471, 328);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(155, 74, 168, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(155, 130, 168, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setBounds(77, 77, 79, 14);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBounds(77, 133, 79, 14);
        frame.getContentPane().add(lblPassword);

        JLabel lblWrong = new JLabel("This username already exists. Try another one");
        lblWrong.setForeground(new Color(255, 0, 0));
        lblWrong.setBounds(122, 161, 271, 14);
        frame.getContentPane().add(lblWrong);
        lblWrong.setVisible(false);

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AccountAccess acc = new AccountAccess();
                ArrayList<Account> aaa = acc.queryRegister(textField.getText());
                Library library = new Library();
                User user = new User(textField.getText(), textField_1.getText());
                int size = aaa.size();
                if (size > 0) {
                    lblWrong.setVisible(true);
                } else {
                    lblWrong.setVisible(false);
                    user.createAccount();
                    ChoosePaymentPlan sh = new ChoosePaymentPlan(textField.getText(), library);
                    sh.show(textField.getText(), library);
                    frame.setVisible(false);
                }

            }
        });
        btnRegister.setBounds(77, 201, 134, 23);
        frame.getContentPane().add(btnRegister);

        JButton btnRegisterAsStaff = new JButton("Register as Staff");
        btnRegisterAsStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AccountAccess acc = new AccountAccess();
                ArrayList<Account> aaa = acc.queryRegister(textField.getText());
                Staff staff = new Staff(textField.getText(), textField_1.getText());
                int size = aaa.size();
                if (size > 0) {
                    lblWrong.setVisible(true);
                } else {
                    lblWrong.setVisible(false);
                    staff.createAccount();
                    ShowLogin sh = new ShowLogin(library);
                    sh.show(library);
                    frame.setVisible(false);
                }
            }
        });
        btnRegisterAsStaff.setBounds(234, 201, 134, 23);
        frame.getContentPane().add(btnRegisterAsStaff);
    }

}
