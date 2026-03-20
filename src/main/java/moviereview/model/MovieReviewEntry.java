package moviereview.model;

import java.time.LocalDate;

public class MovieReviewEntry {
    private String name;
    private Integer score;
    private LocalDate date;
    private String username;

    public MovieReviewEntry(String name, Integer score, LocalDate date, String username){
        this.name = name;
        this.score = score;
        this.date = date;
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public Integer getScore() {
        return this.score;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getUsername() {
        return this.username;
    }

}
