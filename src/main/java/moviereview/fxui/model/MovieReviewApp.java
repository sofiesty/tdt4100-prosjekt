package moviereview.fxui.model;

import com.apple.eawt.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovieReviewApp extends Application {
    // Laster inn fxml filen og lager en "scene" som kjøres og vises
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MovieReview.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Movie Review");
        stage.setScene(scene);
        stage.show();
    } 
}
