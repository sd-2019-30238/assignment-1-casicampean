package bussinessLogic;

import models.Book;

import java.util.ArrayList;
import java.util.Map;

public class Library {

    private ArrayList<Staff> staff;
    private ArrayList<Book>books;
    private Map<Book,ArrayList<User>> waitingList;
}
