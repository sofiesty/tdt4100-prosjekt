package moviereview.fxui;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import moviereview.model.Movies;

public class MovieReviewApp extends Application {
    // Laster inn fxml filen og lager en "scene" som kjøres og vises
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/moviereview/fxui/MovieReview.fxml")); 
        
        Movies movies = new Movies();
        MovieReviewController controller = new MovieReviewController(movies);
        loader.setController(controller);

        Scene scene = new Scene(loader.load());
        
        stage.setTitle("Movie Review");
        stage.setScene(scene);
        stage.show();
    } 
}
