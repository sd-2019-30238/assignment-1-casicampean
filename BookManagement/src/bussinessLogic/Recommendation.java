package bussinessLogic;

import models.Book;

import java.util.ArrayList;

public interface Recommendation {
    ArrayList<Book> getReccomendation(String s);
}
