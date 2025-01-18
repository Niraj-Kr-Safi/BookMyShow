// com.bookmyshow.servlet.BookingServlet.java
package com.bookmyshow.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookmyshow.dao.ShowDAO;
import com.bookmyshow.dao.MovieDAO;
import com.bookmyshow.dao.BookingDAO;
import com.bookmyshow.model.Show;
import com.bookmyshow.model.Movie;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    private ShowDAO showDAO;
    private MovieDAO movieDAO;
    private BookingDAO bookingDAO;

    @Override
    public void init() throws ServletException {
        showDAO = new ShowDAO();
        movieDAO = new MovieDAO();
        bookingDAO = new BookingDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int showId = Integer.parseInt(request.getParameter("showId"));
            int movieId = Integer.parseInt(request.getParameter("movieId"));
            
            Show show = showDAO.getShowById(showId);
            Movie movie = movieDAO.getMovieById(movieId);
            
            request.setAttribute("show", show);
            request.setAttribute("movie", movie);
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
            
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int showId = Integer.parseInt(request.getParameter("showId"));
            int numberOfSeats = Integer.parseInt(request.getParameter("numberOfSeats"));
            int userId = 1; // Assuming user authentication is implemented, get actual user ID
            
            Show show = showDAO.getShowById(showId);
            
            // Validate seat availability
            if (show.getAvailableSeats() < numberOfSeats) {
                request.setAttribute("error", "Not enough seats available");
                doGet(request, response);
                return;
            }
            
            // Calculate total amount
            BigDecimal totalAmount = show.getPrice().multiply(BigDecimal.valueOf(numberOfSeats));
            
            // Create booking
            int bookingId = bookingDAO.createBooking(userId, showId, numberOfSeats, totalAmount);
            
            // Update available seats
            showDAO.updateAvailableSeats(showId, numberOfSeats);
            
            // Redirect to booking confirmation page
            response.sendRedirect(request.getContextPath() + "/booking-confirmation?bookingId=" + bookingId);
            
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}