// com.bookmyshow.servlet.ShowsServlet.java
package com.bookmyshow.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookmyshow.dao.ShowDAO;
import com.bookmyshow.dao.MovieDAO;
import com.bookmyshow.model.Show;
import com.bookmyshow.model.Movie;

@WebServlet("/shows")
public class ShowServlet extends HttpServlet {
    private ShowDAO showsDAO;
    private MovieDAO movieDAO;

    @Override
    public void init() throws ServletException {
        showsDAO = new ShowDAO();
        movieDAO = new MovieDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int movieId = Integer.parseInt(request.getParameter("movieId"));
            Movie movie = movieDAO.getMovieById(movieId);
            List<Show> shows = showsDAO.getShowsByMovieId(movieId);
            
            request.setAttribute("movie", movie);
            request.setAttribute("shows", shows);
            request.getRequestDispatcher("/shows.jsp").forward(request, response);
            
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}