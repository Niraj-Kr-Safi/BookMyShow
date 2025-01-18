// UserDAO.java
package com.bookmyshow.dao;

import com.bookmyshow.model.User;
import com.bookmyshow.util.DBUtil;
import java.sql.*;

public class UserDAO {
    public User authenticate(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password); // In production, use password hashing
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                return user;
            }
        }
        return null;
    }
    
    public boolean registerUser(User user) throws SQLException {
        String sql = "INSERT INTO users (username, email, password, name) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword()); // In production, use password hashing
            pstmt.setString(4, user.getName());
            
            return pstmt.executeUpdate() > 0;
        }
    }
}
