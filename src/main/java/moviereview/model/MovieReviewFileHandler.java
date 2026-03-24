package moviereview.model;
import java.util.Map;
import java.util.Set;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class MovieReviewFileHandler {
    private final String filepath;
    private Set<String> reviewboard = new HashSet<String>();

    public MovieReviewFileHandler(String filepath) {
        if (filepath.isBlank() || filepath == null) {
            throw new IllegalArgumentException("The filepath cannot be null or blank");
        }
        this.filepath = filepath;
    }

    public void saveToFile() {
        //Lagrer alle reviews i reviewboard til en fil
        try (FileWriter filewriter = new FileWriter(this.filepath)) {
            for(String review : reviewboard) {
                filewriter.write(review + "\n");
                filewriter.write("\n");
            } 
        } catch (Exception e) {
            return;
    }
    }

    public static void loadFromFile() {
        
    }
}
