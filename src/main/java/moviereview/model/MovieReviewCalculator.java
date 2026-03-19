package moviereview.model;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieReviewCalculator{

    //String name;
    //HashMap<String, ArrayList<MovieReviewEntry>> movies;

    //public MovieReviewCalculator(String name) {
        //this.name = name;
        
   // }

    public static Integer getAvgReview(String name, Movies movies) {
        double score;
        if (!movies.checkMultipleReviews(name)) {
            return movies.getReviews().get(name).get(1);
        }
        for (MovieReviewEntry movie : movies.getAllReviews(name)) {
            
        }
    }

 

}
