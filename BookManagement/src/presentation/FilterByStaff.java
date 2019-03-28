package presentation;

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

public class FilterByStaff {

    private JFrame frame;
    private JTable table;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FilterByStaff window = new FilterByStaff();
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

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setBounds(74, 48, 329, 163);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(111, 43, 169, 20);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblLabel = new JLabel("Label:");
        lblLabel.setForeground(new Color(255, 255, 255));
        lblLabel.setBounds(22, 46, 79, 14);
        panel.add(lblLabel);

        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnOk.setBounds(123, 104, 89, 23);
        panel.add(btnOk);

        JLabel lblIncorrect = new JLabel("Incorrect");
        lblIncorrect.setForeground(new Color(204, 0, 0));
        lblIncorrect.setBounds(138, 74, 46, 14);
        panel.add(lblIncorrect);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 521, 163);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnByReleaseDate = new JButton("By Release Date");
        btnByReleaseDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnByReleaseDate.setBounds(39, 200, 111, 23);
        frame.getContentPane().add(btnByReleaseDate);

        JButton btnByAuthor = new JButton("By Author");
        btnByAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnByAuthor.setBounds(174, 200, 99, 23);
        frame.getContentPane().add(btnByAuthor);

        JButton btnByTitle = new JButton("By Title");
        btnByTitle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnByTitle.setBounds(291, 200, 99, 23);
        frame.getContentPane().add(btnByTitle);

        JButton btnByGendre = new JButton("By gendre");
        btnByGendre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnByGendre.setBounds(413, 200, 99, 23);
        frame.getContentPane().add(btnByGendre);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBack.setBounds(219, 255, 89, 23);
        frame.getContentPane().add(btnBack);
    }

}
