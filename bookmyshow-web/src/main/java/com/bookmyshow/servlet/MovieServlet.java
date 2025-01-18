// com.bookmyshow.servlet.MovieServlet.java
package com.bookmyshow.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookmyshow.dao.MovieDAO;
import com.bookmyshow.model.Movie;

@WebServlet("/movies")
public class MovieServlet extends HttpServlet {
    private MovieDAO movieDAO;

    @Override
    public void init() throws ServletException {
        movieDAO = new MovieDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String genre = request.getParameter("genre");
            String language = request.getParameter("language");
            
            Set<String> genres = movieDAO.getAllGenres();
            Set<String> languages = movieDAO.getAllLanguages();
            
            List<Movie> movies;
            if ((genre == null || genre.isEmpty()) && (language == null || language.isEmpty())) {
                movies = movieDAO.getAllMovies();
            } else {
                movies = movieDAO.getFilteredMovies(genre, language);
            }
            
            request.setAttribute("movies", movies);
            request.setAttribute("genres", genres);
            request.setAttribute("languages", languages);
            request.setAttribute("selectedGenre", genre);
            request.setAttribute("selectedLanguage", language);
            
            request.getRequestDispatcher("/movies.jsp").forward(request, response);
            
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}