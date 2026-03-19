package moviereview.model;

import java.util.Date;

public class MovieReviewEntry {
    private String name;
    private int score;
    private Date date;
    private String username;

    public MovieReviewEntry(String name, Integer score, Date date, String username){
        this.name = name;
        this.score = score;
        this.date = date;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public Date getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

}
