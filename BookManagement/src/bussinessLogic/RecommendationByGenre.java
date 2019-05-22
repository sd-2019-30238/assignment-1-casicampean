package bussinessLogic;

import dataAccess.BookAccess;
import models.Book;

import java.util.ArrayList;

public class RecommendationByGenre implements Recommendation {
    @Override
    public ArrayList<Book> getReccomendation(String gendre) {
        BookAccess bookAccess = new BookAccess();
        return bookAccess.filterByString("genre", gendre);

    }
}
