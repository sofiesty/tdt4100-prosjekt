package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import moviereview.model.MovieReviewEntry;
import moviereview.model.Movies;
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
}
