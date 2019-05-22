package bussinessLogic;

import models.Book;

import java.util.ArrayList;

public class RecommendationFactory {
    public Recommendation getRecommentations(String recommendation) {
        if (recommendation == null) {
            return null;
        }
        if (recommendation.equalsIgnoreCase("GENRES")) {
            return new RecommendationByGenre();

        } else if (recommendation.equalsIgnoreCase("POPULARITY")) {
            return new RecommendationByPopularity();
        }
        return null;

    }

    public static void main(String[] args) {
        RecommendationFactory r = new RecommendationFactory();
        Recommendation rr = r.getRecommentations("genres");
        System.out.println(rr.getReccomendation("comedy"));
        ArrayList<Book> books = rr.getReccomendation("comedy");
        for (Book b : books) {
            System.out.println(b.getTitle());
        }
    }
}
