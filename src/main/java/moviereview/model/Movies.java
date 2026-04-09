package moviereview.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Movies implements MoviesInterface {
    
    private HashMap<String, ArrayList<MovieReviewEntry>> movies;
    
    
    private void addMovie(MovieReviewEntry review) {
        String movieName = review.getName();

        if (!movies.containsKey(movieName)) {
            movies.put(movieName, new ArrayList<>());
        }

        movies.get(movieName).add(review);
    }

    public Movies(){
        this.movies = new HashMap<>();
    }

    @Override
    public void addReview(String title, String username, LocalDate date, Integer score) {
        MovieReviewEntry movieReview = new MovieReviewEntry(title, score, date, username);
        addMovie(movieReview);
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
