package moviereview.model;

public class MovieReviewCalculator{
    private Movies movies;

    public MovieReviewCalculator(Movies movies) {
        this.movies = movies;
    }

    public Set<Integer> 

    private Integer getAvgReview(String name) {
        Integer score = 0;

        if (!this.movies.checkMultipleReviews(name)) {
            return this.movies.get(name).getScore();
        }

        for (MovieReviewEntry movie : movies.getAllReviews(name)) {
                score += movie.getScore();
        }

        return (Integer) Math.round(score / movies.getAllReviews(name).size());

    }
}
