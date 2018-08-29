package com.yatop.modal;

public class Movie {

    private String id;
    //电影名称
    private String title;
    //评分
    private String rate;
    //发行时间
    private String releaseYear;
    //上映时间
    private String sendTime;
    //导演
    private String director;

    public Movie() {
    }

    public Movie(String title, String rate, String sendTime, String director) {
        this.title = title;
        this.rate = rate;
        this.sendTime = sendTime;
        this.director = director;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
