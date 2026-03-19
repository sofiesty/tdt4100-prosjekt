package moviereview.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Movies {
    
    private HashMap<String, ArrayList<MovieReviewEntry>> movies;

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

    public boolean checkMultipleReviews(String name) {
        if (name.equals(null)) {
            throw new IllegalStateException("Name can't be null");
        }
        if (movies.get(name).size() > 1) {
            return true;
        }return false;
    }

    public ArrayList<MovieReviewEntry> getAllReviews(String name) {
        return movies.get(name);
    }

    public HashMap<String, ArrayList<MovieReviewEntry>> getReviews() {
        return Collections.unmodifiableMap(movies);
    }

}
