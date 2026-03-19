package moviereview.model;

public class MovieReviewCalculator{

    public static Integer getAvgReview(String name, Movies movies) {
        double score = 0;

        if (!movies.getReviews().containsKey(name)) {
            throw new IllegalStateException("The movie doesn't exist");
        } 

        if (!movies.checkMultipleReviews(name)) {
            return movies.getReviews().get(name).get(0).getScore();
        }

        for (MovieReviewEntry movie : movies.getAllReviews(name)) {
                score += movie.getScore();
        }

        return (int) Math.round(score / movies.getAllReviews(name).size());

    }
}
