package moviereview.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MovieReviewCalculator{
    private Movies movies;
    private List<Integer> reviews = new ArrayList<>();
    private List<Integer> scores = new ArrayList<>();

    public MovieReviewCalculator(Movies movies) {
        this.movies = movies;
    }

    public List<Integer> getReviews() {
        return Collections.unmodifiableList(this.reviews);
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(this.scores);
    }

    public void calculate() {
        this.scores.clear();
        this.reviews.clear();

        for (String name : movies.getMovieTitles()) {
            this.scores.add(AvgScore(name));
            this.reviews.add(movies.getAllReviews(name).size());
        }
    }

    private void AvgScore(String name) {
        Integer score = 0;

        if (!this.movies.checkMultipleReviews(name)) {
            return this.movies.get(name).getScore();
        }

        for (MovieReviewEntry movie : movies.getAllReviews(name)) {
                score += movie.getScore();
        }

        return (int) Math.round((double) score / movies.getAllReviews(name).size());

    }
}
