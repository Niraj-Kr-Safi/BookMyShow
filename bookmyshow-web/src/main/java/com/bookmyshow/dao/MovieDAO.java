// com.bookmyshow.dao.MovieDAO.java
package com.bookmyshow.dao;

import com.bookmyshow.model.Movie;
import com.bookmyshow.util.DBUtil;
import java.sql.*;
import java.util.*;

public class MovieDAO {
    
    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies";
        
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                movies.add(extractMovieFromResultSet(rs));
            }
        }
        return movies;
    }

    public Movie getMovieById(int movieId) throws SQLException {
        String sql = "SELECT * FROM movies WHERE movie_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, movieId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return extractMovieFromResultSet(rs);
            }
        }
        return null;
    }

    public List<Movie> getFilteredMovies(String genre, String language) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM movies WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (genre != null && !genre.isEmpty()) {
            sql.append(" AND genre = ?");
            params.add(genre);
        }
        if (language != null && !language.isEmpty()) {
            sql.append(" AND language = ?");
            params.add(language);
        }

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                movies.add(extractMovieFromResultSet(rs));
            }
        }
        return movies;
    }

    public Set<String> getAllGenres() throws SQLException {
        Set<String> genres = new HashSet<>();
        String sql = "SELECT DISTINCT genre FROM movies WHERE genre IS NOT NULL";
        
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                genres.add(rs.getString("genre"));
            }
        }
        return genres;
    }

    public Set<String> getAllLanguages() throws SQLException {
        Set<String> languages = new HashSet<>();
        String sql = "SELECT DISTINCT language FROM movies WHERE language IS NOT NULL";
        
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                languages.add(rs.getString("language"));
            }
        }
        return languages;
    }

    private Movie extractMovieFromResultSet(ResultSet rs) throws SQLException {
        Movie movie = new Movie();
        movie.setMovieId(rs.getInt("movie_id"));
        movie.setTitle(rs.getString("title"));
        movie.setGenre(rs.getString("genre"));
        movie.setDuration(rs.getInt("duration"));
        movie.setLanguage(rs.getString("language"));
        return movie;
    }
}