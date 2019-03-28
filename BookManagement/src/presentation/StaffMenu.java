package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffMenu {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StaffMenu window = new StaffMenu();
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
            StaffMenu window = new StaffMenu();
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
        frame.getContentPane().setLayout(null);

        JButton btnShowBorrowedHistory = new JButton("Show Borrowed History");
        btnShowBorrowedHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ShowBorrowedHistory h= new ShowBorrowedHistory();
                h.show();
            }
        });
        btnShowBorrowedHistory.setBounds(72, 49, 170, 23);
        frame.getContentPane().add(btnShowBorrowedHistory);

        JButton btnFilterBy = new JButton("Filter By ");
        btnFilterBy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                FilterByStaff f = new FilterByStaff();
                frame.setVisible(false);
            }
        });
        btnFilterBy.setBounds(72, 152, 170, 23);
        frame.getContentPane().add(btnFilterBy);



        JButton btnShowAllAccounts = new JButton("Show all accounts");
        btnShowAllAccounts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ShowAllAccounts acc = new ShowAllAccounts();
                acc.show();
            }
        });
        btnShowAllAccounts.setBounds(72, 104, 170, 23);
        frame.getContentPane().add(btnShowAllAccounts);
        frame.setBounds(100, 100, 350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
