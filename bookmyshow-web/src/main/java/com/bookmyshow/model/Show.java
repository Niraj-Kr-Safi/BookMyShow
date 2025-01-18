// com.bookmyshow.model.Shows.java
package com.bookmyshow.model;

import java.util.Date;
import java.math.BigDecimal;

public class Show {
    private int showId;
    private int movieId;
    private Date showTime;  // Changed from LocalDateTime to Date
    private BigDecimal price;
    private int availableSeats;

    // Constructors
    public Show() {}

    public Show(int showId, int movieId, Date showTime, BigDecimal price, int availableSeats) {
        this.showId = showId;
        this.movieId = movieId;
        this.showTime = showTime;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    // Getters and Setters
    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }

    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

    public Date getShowTime() { return showTime; }
    public void setShowTime(Date showTime) { this.showTime = showTime; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
}