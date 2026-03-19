package moviereview.fxui.model;

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
        String title = movieTitleField.getText();
        String username = usernameField.getText();
        Date date = reviewDatePicker.getValue();
        Integer score = ratingSpinner.getValue();

        if (title.isBlank() || username.isBlank() || date == null) {
        statusLabel.setText("Please fill in all fields.");
        return;
        }

        MovieReviewEntry movieReview = new MovieReviewEntry(title, score, date, username);
        Movies.addMovie(movieReview);

        movieTableView.setItems(FXCollections.observableArrayList(Movies.getReviews().keySet()) ); 
        statusLabel.setText("");
    
        // Tømmer feltene
        movieTitleField.clear();
        usernameField.clear();
        reviewDatePicker.setValue(null);
        ratingSpinner.getValueFactory().setValue(3);
    }

    @FXML
    private void handleSortByRating() {

    }

}
