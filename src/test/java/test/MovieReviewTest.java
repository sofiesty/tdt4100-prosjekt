package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import moviereview.model.MovieReviewCalculator;
import moviereview.model.MovieReviewEntry;
import moviereview.model.Movies;
import moviereview.*;
import java.util.ArrayList;

public class MovieReviewTest {

    @Test
    public void testMovieIsAddedCorrect() {
        Movies movies = new Movies();

        MovieReviewEntry movie = new MovieReviewEntry("Pingu", 5, LocalDate.of(2026, 4, 7), "celinehag");
        movies.addMovie(movie);

        ArrayList<MovieReviewEntry> test = movies.getAllReviews("Pingu");
        
        assertEquals("Pingu", test.get(0).getName());
        assertEquals(5, test.get(0).getScore());
        assertEquals(LocalDate.of(2026, 4, 7), test.get(0).getDate());
        assertEquals("celinehag", test.get(0).getUsername());

    }

    @Test
    public void testgetAverageScore() {
        Movies movies = new Movies();
        MovieReviewCalculator calculator = new MovieReviewCalculator(movies);

        MovieReviewEntry movie = new MovieReviewEntry("Pingu", 5, LocalDate.of(2026, 4, 7), "celinehag");
        MovieReviewEntry movie2 = new MovieReviewEntry("Pingu", 3, LocalDate.of(2026, 4, 7), "celinehag");
        
        movies.addMovie(movie);
        movies.addMovie(movie2);

        assertEquals(4, calculator.avgScore("Pingu")); 
    }
}
