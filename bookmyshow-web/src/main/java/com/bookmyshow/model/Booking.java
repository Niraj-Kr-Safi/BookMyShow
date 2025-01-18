// com.bookmyshow.model.Booking.java
package com.bookmyshow.model;

import java.util.Date;
import java.math.BigDecimal;

public class Booking {
    private int bookingId;
    private int userId;
    private int showId;
    private int numberOfSeats;
    private BigDecimal totalAmount;
    private Date bookingTime;

    // Constructors
    public Booking() {}

    public Booking(int bookingId, int userId, int showId, int numberOfSeats, 
                  BigDecimal totalAmount, Date bookingTime) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.showId = showId;
        this.numberOfSeats = numberOfSeats;
        this.totalAmount = totalAmount;
        this.bookingTime = bookingTime;
    }

    // Getters and Setters
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }

    public int getNumberOfSeats() { return numberOfSeats; }
    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public Date getBookingTime() { return bookingTime; }
    public void setBookingTime(Date bookingTime) { this.bookingTime = bookingTime; }
}
