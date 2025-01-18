// com.bookmyshow.model.Movie.java
package com.bookmyshow.model;

public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private int duration;
    private String language;

    // Constructors
    public Movie() {}

    public Movie(int movieId, String title, String genre, int duration, String language) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.language = language;
    }

    // Getters and Setters
    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
}
