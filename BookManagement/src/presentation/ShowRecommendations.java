package presentation;

import bussinessLogic.Library;
import bussinessLogic.Recommendation;
import bussinessLogic.RecommendationFactory;
import dataAccess.Reflection;
import models.Book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;

public class ShowRecommendations {

    private JFrame frame;
    private JTable table;
    private JTextField textField;
    private int id;
    private Library library;

    /**
     * Launch the application.
     */


    public void show(int id, Library library){
        try {
            ShowRecommendations window = new ShowRecommendations(id, library);
            window.initialize();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ShowRecommendations(int id, Library library){
        this.id = id;
        this.library = library;
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 0, 51));
        frame.getContentPane().setForeground(new Color(0, 0, 51));
        frame.setBounds(100, 100, 647, 375);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        table = new JTable();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(12, 23, 605, 204);
        frame.getContentPane().add(scrollPane);



        textField = new JTextField();
        textField.setBounds(263, 255, 158, 22);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblTryAgain = new JLabel("Incorrect title");
        lblTryAgain.setForeground(new Color(255, 0, 0));
        lblTryAgain.setBounds(273, 240, 116, 14);
        frame.getContentPane().add(lblTryAgain);
        lblTryAgain.setVisible(false);

        RecommendationFactory recommendationFactory = new RecommendationFactory();

        JButton btnRecommendByGenre = new JButton("Recommend by Genre");
        btnRecommendByGenre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Recommendation recommendation = recommendationFactory.getRecommentations("genres");
                ArrayList<Book> books = recommendation.getReccomendation(textField.getText());
                System.out.println(books.size());
                if(books.size() > 0){
                    lblTryAgain.setVisible(false);
                    textField.setText("");
                    table = Reflection.retrieveProperties(books, 7);
                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBounds(12, 23, 605, 204);
                    frame.getContentPane().add(scrollPane);

                }
                else{
                    lblTryAgain.setVisible(true);
                    textField.setText("");
                }
            }
        });
        btnRecommendByGenre.setBounds(263, 290, 215, 25);
        frame.getContentPane().add(btnRecommendByGenre);

        JButton btnRecommendPopularBooks = new JButton("Recommend popular books");
        btnRecommendPopularBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Recommendation recommendation = recommendationFactory.getRecommentations("popularity");
                ArrayList<Book> books = recommendation.getReccomendation(textField.getText());
                if(books.size() > 0){
                    lblTryAgain.setVisible(false);
                    lblTryAgain.setText("Try again");
                    table = Reflection.retrieveProperties(books, 7);
                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBounds(12, 23, 605, 204);
                    frame.getContentPane().add(scrollPane);

                }
                else{
                    lblTryAgain.setText("No recommendations for now");
                    lblTryAgain.setVisible(true);
                }
            }
        });
        btnRecommendPopularBooks.setBounds(26, 290, 215, 25);
        frame.getContentPane().add(btnRecommendPopularBooks);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                UserMenu userMenu = new UserMenu(id, library);
                userMenu.show(id,library);

            }
        });
        btnBack.setBounds(506, 290, 97, 25);
        frame.getContentPane().add(btnBack);

        JLabel lblFavouriteGenre = new JLabel("Favourite genre:");
        lblFavouriteGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblFavouriteGenre.setForeground(new Color(255, 255, 255));
        lblFavouriteGenre.setBounds(139, 256, 128, 18);
        frame.getContentPane().add(lblFavouriteGenre);
    }

}

