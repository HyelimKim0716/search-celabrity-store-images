package com.kakaobank.assignment.searchimage.data.model.video;

public class Document {

    private String title;
    private String url;
    private String datetime;
    private String play_time;
    private String thumbnail;
    private String author;

    public Document(String title, String url, String datetime, String play_time, String thumbnail, String author) {
        this.title = title;
        this.url = url;
        this.datetime = datetime;
        this.play_time = play_time;
        this.thumbnail = thumbnail;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getPlay_time() {
        return play_time;
    }

    public void setPlay_time(String play_time) {
        this.play_time = play_time;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
