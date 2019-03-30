package bussinessLogic;

import dataAccess.BookAccess;
import models.Book;

import java.util.ArrayList;

public class RecommendationByPopularity implements Recommendation {
    @Override
    public ArrayList<Book> getReccomendation(String s) {
        BookAccess bookAccess = new BookAccess();
        return bookAccess.getBooksByPopularity();


    }
}
