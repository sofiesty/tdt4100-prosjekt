package moviereview.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

public class MovieReviewFileHandler {
    private final String filepath;

    public MovieReviewFileHandler(String filepath) {
        if (filepath.isBlank() || filepath == null) {
            throw new IllegalArgumentException("The filepath cannot be null or blank");
        }
        this.filepath = filepath;
    }

    public void saveToFile(Movies movies) {
        //Lagrer alle reviews i reviewboard til en fil
        try (FileWriter filewriter = new FileWriter(this.filepath)) {
            for(String movieName : movies.getMovieTitles()) {
                for (MovieReviewEntry review : movies.getAllReviews(movieName)) {
                    String reviewString = review.getName() + "," + review.getScore() + "," + review.getDate() + "," + review.getUsername() + "\n";
                    filewriter.write(reviewString);
                }
            } 
        } catch (Exception e) {
            System.err.println(e.getMessage());
    }
    }

    public void loadFromFile(Movies movies) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    Integer score = Integer.parseInt(parts[1].trim());
                    LocalDate date = LocalDate.parse(parts[2].trim());
                    String username = parts[3].trim();

                    MovieReviewEntry entry = new MovieReviewEntry(name, score, date, username);
                    movies.addMovie(entry);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
