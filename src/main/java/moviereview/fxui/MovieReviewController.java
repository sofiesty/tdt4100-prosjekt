package moviereview.fxui;

import java.time.LocalDate;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import moviereview.model.MovieReviewCalculator;
import moviereview.model.MovieReviewFileHandler;
import moviereview.model.Movies;


public class MovieReviewController {
    @FXML private TableView<String> movieTableView;
    @FXML private TableColumn<String, String>  movieTitleColumn;
    @FXML private TableColumn<String, Double>  averageRatingColumn;
    @FXML private TableColumn<String, Integer> reviewCountColumn;

    @FXML private TextField  movieTitleField;
    @FXML private TextField  usernameField;
    @FXML private Spinner<Integer> ratingSpinner;
    @FXML private DatePicker reviewDatePicker;

    @FXML private Button addReviewButton;
    @FXML private Button sortByRatingButton;
    @FXML private Label  statusLabel;

    private final Movies movies;
    private final MovieReviewCalculator calculator;
    private final MovieReviewFileHandler FileHandler = new MovieReviewFileHandler("review.txt");
    private final ObservableList<String> movieList = FXCollections.observableArrayList();


    public MovieReviewController(Movies movies, MovieReviewCalculator calculator) {
        this.movies = movies;
        this.calculator = calculator;
    }

    @FXML
    public void initialize() {
        movieTitleColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

        averageRatingColumn.setCellValueFactory(data -> new SimpleDoubleProperty(calculator.avgScore(data.getValue())).asObject());

        reviewCountColumn.setCellValueFactory(data -> new SimpleIntegerProperty(calculator.getNumberOfReviews(data.getValue())).asObject());
        movieTableView.setItems(movieList); 
    }

    @FXML
    private void handleAddReview() {
        // Henter info fra feltene bruker har fylt inn 
        String title = movieTitleField.getText().trim();
        String username = usernameField.getText().trim();
        LocalDate date = reviewDatePicker.getValue();
        Integer score = ratingSpinner.getValue();

        if (title.isBlank() || username.isBlank() || date == null) {
            statusLabel.setText("Please fill in all fields.");
            return;
        }

        this.movies.addReview(title, username, date, score); 
        calculator.avgScore(title);

        // Gir tabellen alle film navnene i en observable liste
        movieList.setAll(this.movies.getMovieTitles());
        statusLabel.setText("");
    
        // Tømmer feltene
        movieTitleField.clear();
        usernameField.clear();
        reviewDatePicker.setValue(null);
        ratingSpinner.getValueFactory().setValue(1);
    }

    @FXML
    private void handleSortByRating() {
        // Sorterer tabellen etter gjennomsnittlig rating
        movieTableView.getItems().sort((m1,m2) -> Double.compare(calculator.avgScore(m2), calculator.avgScore(m1))); 
    }

    @FXML
    private void handleSaveToFile() {
        // Lagrer alle reviews i reviewboard til en fil
        FileHandler.saveToFile(this.movies);

        statusLabel.setText("Reviews saved to file.");
    }

    @FXML
    private void handleLoadFromFile() {
        FileHandler.loadFromFile(this.movies); // laster data tilbake inn i Movies    

        movieList.setAll(this.movies.getMovieTitles());
        movieTableView.setItems(movieList);
        movieTableView.refresh();
    
        statusLabel.setText("Reviews loaded from file.");
    }
}
