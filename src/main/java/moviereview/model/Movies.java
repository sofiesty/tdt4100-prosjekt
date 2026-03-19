package moviereview.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Movies {
    private HashMap<String, ArrayList<MovieReviewEntry>> movies;

    public Movies(HashMap<String, ArrayList<MovieReviewEntry>> movies){
        this.movies = new HashMap<>();
    }

    public void addMovie(MovieReviewEntry review) {
        String movieName = review.getName();

        if (!movies.containsKey(movieName)) {
            movies.put(movieName, new ArrayList<>());
        }

        movies.get(movieName).add(review);
    }

}
