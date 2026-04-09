package test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import moviereview.model.MovieReviewCalculator;
import moviereview.model.MovieReviewEntry;
import moviereview.model.MovieReviewFileHandler;
import moviereview.model.Movies;

public class MovieReviewTest {

    @Test
    public void testMovieIsAddedCorrect() {
        Movies movies = new Movies();
        
        MovieReviewEntry movie = new MovieReviewEntry("Pingu", 5, "celinehag");
        movies.addMovie(movie);

        ArrayList<MovieReviewEntry> test = movies.getAllReviews("Pingu");
        
        assertEquals("Pingu", test.get(0).getName());
        assertEquals(5, test.get(0).getScore());
        assertEquals("celinehag", test.get(0).getUsername());

    }

    @Test
    public void testgetAverageScore() {
        Movies movies = new Movies();
        MovieReviewCalculator calculator = new MovieReviewCalculator(movies);

        MovieReviewEntry movie = new MovieReviewEntry("Pingu", 5, "celinehag");
        MovieReviewEntry movie2 = new MovieReviewEntry("Pingu", 3, "celinehag");
        
        movies.addMovie(movie);
        movies.addMovie(movie2);

        assertEquals(4.0, (double)calculator.avgScore("Pingu")); 
    }

    @Test
    public void testSaveLoadtoFile() {
        Movies movies = new Movies();
       
        MovieReviewEntry movie1 = new MovieReviewEntry("Pingu", 5, "celinehag");
        MovieReviewEntry movie2 = new MovieReviewEntry("Pingu", 4, "celinehag");
        MovieReviewEntry movie3 = new MovieReviewEntry("Pingu", 5, "celinehag");
        MovieReviewEntry movie4 = new MovieReviewEntry("Happy Feet", 6, "sofiesty");
        MovieReviewEntry movie5 = new MovieReviewEntry("Harry Potter", 6, "sofiesty");
        MovieReviewEntry movie6 = new MovieReviewEntry("Star Wars", 2, "sofiesty");

        movies.addMovie(movie1);
        movies.addMovie(movie2);
        movies.addMovie(movie3);
        movies.addMovie(movie4);
        movies.addMovie(movie5);

        MovieReviewFileHandler fileHandler = new MovieReviewFileHandler("review.txt");
        fileHandler.saveToFile(movies);

        Movies movies2 = new Movies();
        MovieReviewFileHandler fileHandler2 = new MovieReviewFileHandler("review.txt");
        fileHandler2.loadFromFile(movies2);

        assertEquals(movies.getMovieTitles(), movies2.getMovieTitles());

        movies2.addMovie(movie6);

        assertNotEquals(movies.getMovieTitles(), movies2.getMovieTitles());
    }

    @Test
    public void setInvalidType() {
        // score is 8, which is not allowed
        assertThrows(IllegalArgumentException.class, () -> {
            new MovieReviewEntry("Star Wars", 8, "sofiesty");
        });
    } 
    
    @Test
    public void reset() {
        Movies movies = new Movies();
       
        MovieReviewEntry movie1 = new MovieReviewEntry("Pingu", 5, "celinehag");
        MovieReviewEntry movie2 = new MovieReviewEntry("Pingu", 4, "celinehag");
        MovieReviewEntry movie3 = new MovieReviewEntry("Pingu", 5, "celinehag");
        MovieReviewEntry movie4 = new MovieReviewEntry("Happy Feet", 6, "sofiesty");
        MovieReviewEntry movie5 = new MovieReviewEntry("Harry Potter", 6, "sofiesty");

        movies.addMovie(movie1);
        movies.addMovie(movie2);
        movies.addMovie(movie3);
        movies.addMovie(movie4);
        movies.addMovie(movie5);

        movies.clear();

        assertTrue(movies.getMovieTitles().isEmpty());
    }

    @Test
    public void testGetAllReviews() {
        Movies movies = new Movies();
        MovieReviewCalculator calculator = new MovieReviewCalculator(movies);
       
        MovieReviewEntry movie1 = new MovieReviewEntry("Pingu", 5, "celinehag");
        MovieReviewEntry movie2 = new MovieReviewEntry("Pingu", 4, "celinehag");
        MovieReviewEntry movie3 = new MovieReviewEntry("Pingu", 5, "celinehag");
        MovieReviewEntry movie4 = new MovieReviewEntry("Happy Feet", 6, "sofiesty");
        MovieReviewEntry movie5 = new MovieReviewEntry("Harry Potter", 6, "sofiesty");

        movies.addMovie(movie1);
        movies.addMovie(movie2);
        movies.addMovie(movie3);
        movies.addMovie(movie4);
        movies.addMovie(movie5);
        
        assertEquals(3, calculator.getNumberOfReviews("Pingu"));
    }
}
