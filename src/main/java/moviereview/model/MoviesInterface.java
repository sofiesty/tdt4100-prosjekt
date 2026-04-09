package moviereview.model;

import java.util.ArrayList;
import java.util.Set;

public interface MoviesInterface {
    Boolean addReview(String title, String username, Integer score);
    Set<String> getMovieTitles();
    ArrayList<MovieReviewEntry> getAllReviews(String name);
    void clear();
}
