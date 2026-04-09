package moviereview.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Movies implements MoviesInterface {
    
    private final HashMap<String, ArrayList<MovieReviewEntry>> movies;
    

    public Movies(){
        this.movies = new HashMap<>();
    }

    public void addMovie(MovieReviewEntry review) {
        String movieName = review.getName();

        if (!movies.containsKey(movieName)) {
            movies.put(movieName, new ArrayList<>());
        }

        movies.get(movieName).add(review);
    }

    @Override
    public Boolean addReview(String title, String username, Integer score) {
        if (title.isBlank() || username.isBlank()) { 
            return false;
        }

        MovieReviewEntry movieReview = new MovieReviewEntry(title, score, username);
        addMovie(movieReview);
        return true;
    }

    @Override
    public ArrayList<MovieReviewEntry> getAllReviews(String name) {
        return movies.get(name);
    }

    @Override
    public Set<String> getMovieTitles() {
        return Collections.unmodifiableSet(movies.keySet());
    }

    @Override
    public void clear() {
        movies.clear();
    }
}
