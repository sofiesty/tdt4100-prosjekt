package moviereview.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Movies implements MoviesInterface {
    
    private HashMap<String, ArrayList<MovieReviewEntry>> movies;
    

    public Movies(){
        this.movies = new HashMap<>();
    }

    @Override
    public void addMovie(MovieReviewEntry review) {
        String movieName = review.getName();

        if (!movies.containsKey(movieName)) {
            movies.put(movieName, new ArrayList<>());
        }

        movies.get(movieName).add(review);
    } 

    /* 
    public boolean checkMultipleReviews(String name) {
        if (!movies.containsKey(name)) {
            return false;
        }return movies.get(name).size() > 1;
    }*/
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
