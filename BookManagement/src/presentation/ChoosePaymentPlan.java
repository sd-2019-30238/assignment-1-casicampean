package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class ChoosePaymentPlan {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChoosePaymentPlan window = new ChoosePaymentPlan();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public  void show(){
        try {
            ChoosePaymentPlan window = new ChoosePaymentPlan();
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
        frame.setBounds(100, 100, 457, 296);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("15$");
        label.setForeground(new Color(51, 204, 255));
        label.setFont(new Font("Tahoma", Font.PLAIN, 28));
        label.setBounds(42, 63, 46, 41);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("75$");
        label_1.setForeground(new Color(51, 204, 255));
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
        label_1.setBounds(183, 69, 46, 28);
        frame.getContentPane().add(label_1);

        JLabel label_2 = new JLabel("120$");
        label_2.setForeground(new Color(51, 204, 255));
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
        label_2.setBounds(335, 69, 74, 28);
        frame.getContentPane().add(label_2);

        JLabel lblPerMonth = new JLabel("Per month");
        lblPerMonth.setForeground(new Color(51, 204, 255));
        lblPerMonth.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPerMonth.setBounds(21, 140, 109, 18);
        frame.getContentPane().add(lblPerMonth);

        JLabel lblPerMonth_1 = new JLabel("Per month");
        lblPerMonth_1.setForeground(new Color(51, 204, 255));
        lblPerMonth_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPerMonth_1.setBounds(169, 140, 98, 18);
        frame.getContentPane().add(lblPerMonth_1);

        JLabel lblPerYear = new JLabel("Per year");
        lblPerYear.setForeground(new Color(51, 204, 255));
        lblPerYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPerYear.setBounds(335, 140, 74, 18);
        frame.getContentPane().add(lblPerYear);

        JButton btnSet = new JButton("Set");
        btnSet.setBounds(39, 195, 74, 23);
        frame.getContentPane().add(btnSet);

        JButton btnSet_1 = new JButton("Set");
        btnSet_1.setBounds(183, 195, 67, 23);
        frame.getContentPane().add(btnSet_1);

        JButton btnSet_2 = new JButton("Set");
        btnSet_2.setBounds(335, 195, 74, 23);
        frame.getContentPane().add(btnSet_2);
    }
}
