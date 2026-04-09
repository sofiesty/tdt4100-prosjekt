package moviereview.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MovieReviewCalculator{
    private final Movies movies;
    private final List<Integer> reviews = new ArrayList<>();
    private final List<Integer> scores = new ArrayList<>();

    public MovieReviewCalculator(Movies movies) {
        this.movies = movies;
    }

    public List<Integer> getReviews() {
        return Collections.unmodifiableList(this.reviews);
    }

    public int getNumberOfReviews(String title) {
        return movies.getAllReviews(title).size();
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(this.scores); 
    }

    public void calculate() {
        this.scores.clear();
        this.reviews.clear();

        for (String name : movies.getMovieTitles()) {
            this.scores.add(avgScore(name));
            this.reviews.add(movies.getAllReviews(name).size());
        }
    }

    public int avgScore(String name) {
        List<MovieReviewEntry> specificReviews = movies.getAllReviews(name);
        if (specificReviews.isEmpty()) return 0;
        
        int total = 0;

        for (MovieReviewEntry entry : specificReviews) {
            total += entry.getScore();
        }

        return (int) Math.round((double) total / specificReviews.size());
    }
}
