package moviereview.model;

import java.util.Date;

public class MovieReviewEntry {
    private String name;
    private Integer score;
    private Date date;
    private String username;

    public MovieReviewEntry(String name, Integer score, Date date, String username){
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

    public Date getDate() {
        return this.date;
    }

    public String getUsername() {
        return this.username;
    }

}
