package moviereview.model;

import java.util.ArrayList;
import java.util.Set;

public interface MoviesInterface {
    void addMovie(MovieReviewEntry movieReviewEntry);
    Set<String> getMovieTitles();
    ArrayList<MovieReviewEntry> getAllReviews(String name);
    void clear();
}
