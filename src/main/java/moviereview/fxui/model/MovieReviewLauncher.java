package moviereview.fxui.model;

import com.apple.eawt.Application;

public class MovieReviewLauncher {
    // Main metode untatt extends application fordi det kan gi problemer
    public static void main(String[] args) {
        Application.launch(MovieReviewApp.class, args);
    } 
}
