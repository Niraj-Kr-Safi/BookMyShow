// com.bookmyshow.dao.ShowsDAO.java
package com.bookmyshow.dao;

import com.bookmyshow.model.Show;
import com.bookmyshow.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowDAO {
    
    public List<Show> getShowsByMovieId(int movieId) throws SQLException {
        List<Show> showsList = new ArrayList<>();
        String sql = "SELECT * FROM shows WHERE movie_id = ? ORDER BY show_time";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, movieId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Show show = new Show();
                show.setShowId(rs.getInt("show_id"));
                show.setMovieId(rs.getInt("movie_id"));
                show.setShowTime(rs.getTimestamp("show_time"));  // Timestamp is converted to Date automatically
                show.setPrice(rs.getBigDecimal("price"));
                show.setAvailableSeats(rs.getInt("available_seats"));
                showsList.add(show);
            }
        }
        return showsList;
    }

    // ... rest of the methods remain the same ...
}