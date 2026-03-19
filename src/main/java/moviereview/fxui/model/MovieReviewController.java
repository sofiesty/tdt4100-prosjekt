package moviereview.fxui.model;

import java.util.Date;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import moviereview.model.MovieReviewEntry;
import moviereview.model.Movies;

public class MovieReviewController {
    @FXML private TableView<Movies> movieTableView;
    @FXML private TableColumn<Movies, String>  movieTitleColumn;
    @FXML private TableColumn<Movies, Double>  averageRatingColumn;
    @FXML private TableColumn<Movies, Integer> reviewCountColumn;

    @FXML private TextField  movieTitleField;
    @FXML private TextField  usernameField;
    @FXML private Spinner<Integer> ratingSpinner;
    @FXML private DatePicker reviewDatePicker;

    @FXML private Button addReviewButton;
    @FXML private Button sortByRatingButton;
    @FXML private Label  statusLabel;

    @FXML
    public void initialize() {
        movieTitleColumn.setCellValueFactory(
            new PropertyValueFactory<>("title"));        
        averageRatingColumn.setCellValueFactory(
            new PropertyValueFactory<>("averageRating")); 
        reviewCountColumn.setCellValueFactory(
            new PropertyValueFactory<>("reviewCount"));  
    }

    @FXML
    private void handleAddReview() {
        // Henter info fra feltene bruker har fylt inn 
        String title = movieTitleField.getText();
        String username = usernameField.getText();
        Date date = reviewDatePicker.getValue();
        Integer score = ratingSpinner.getValue();

        if (title.isBlank() || username.isBlank() || date == null) {
        statusLabel.setText("Please fill in all fields.");
        return;
        }

        // Lager ny 
        MovieReviewEntry movieReview = new MovieReviewEntry(title, score, date, username);
        Movies.addMovie(movieReview);

        // Gir tabellen alle film navnene i en observable liste
        movieTableView.setItems(FXCollections.observableArrayList(Movies.getReviews().keySet()) ); 
        statusLabel.setText("");
    
        // Tømmer feltene
        movieTitleField.clear();
        usernameField.clear();
        reviewDatePicker.setValue(null);
        ratingSpinner.getValueFactory().setValue(1);
    }

    @FXML
    private void handleSortByRating() {

    }

}
