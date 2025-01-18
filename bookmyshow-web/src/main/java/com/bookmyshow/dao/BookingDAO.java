// com.bookmyshow.dao.BookingDAO.java
package com.bookmyshow.dao;

import com.bookmyshow.model.Booking;
import com.bookmyshow.util.DBUtil;
import java.sql.*;
import java.math.BigDecimal;

public class BookingDAO {
    
    public int createBooking(int userId, int showId, int numberOfSeats, BigDecimal totalAmount) 
            throws SQLException {
        String sql = "INSERT INTO bookings (user_id, show_id, number_of_seats, total_amount, booking_time) " +
                    "VALUES (?, ?, ?, ?, NOW())";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, userId);
            stmt.setInt(2, showId);
            stmt.setInt(3, numberOfSeats);
            stmt.setBigDecimal(4, totalAmount);
            
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating booking failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating booking failed, no ID obtained.");
                }
            }
        }
    }

    public Booking getBookingById(int bookingId) throws SQLException {
        String sql = "SELECT * FROM bookings WHERE booking_id = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingId(rs.getInt("booking_id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setShowId(rs.getInt("show_id"));
                booking.setNumberOfSeats(rs.getInt("number_of_seats"));
                booking.setTotalAmount(rs.getBigDecimal("total_amount"));
                booking.setBookingTime(rs.getTimestamp("booking_time"));
                return booking;
            }
        }
        return null;
    }
}
