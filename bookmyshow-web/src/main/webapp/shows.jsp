<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${movie.title} - Show Times</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .show-card {
            transition: transform 0.3s;
            border: 1px solid #ddd;
            margin-bottom: 15px;
            padding: 15px;
            border-radius: 8px;
        }
        .show-card:hover {
            transform: translateY(-3px);
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        .movie-details {
            background-color: #f8f9fa;
            padding: 20px;
            margin-bottom: 30px;
            border-radius: 8px;
        }
    </style>
</head>
<body>

<div class="container py-5">
    <!-- Movie Details Section -->
    <div class="movie-details">
        <h2>${movie.title}</h2>
        <div class="row">
            <div class="col-md-4">
                <p><strong>Genre:</strong> ${movie.genre}</p>
            </div>
            <div class="col-md-4">
                <p><strong>Duration:</strong> ${movie.duration} minutes</p>
            </div>
            <div class="col-md-4">
                <p><strong>Language:</strong> ${movie.language}</p>
            </div>
        </div>
    </div>

    <!-- Shows Section -->
    <h3 class="mb-4">Available Shows</h3>
    <div class="row">
        <c:forEach var="show" items="${shows}">
            <div class="col-md-4">
                <div class="show-card">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h5 class="mb-0">
                            <fmt:formatDate type="time" value="${show.showTime}" pattern="hh:mm a" />
                        </h5>
                        <span class="badge bg-primary">
                            <fmt:formatDate type="date" value="${show.showTime}" pattern="EEE, MMM d" />
                        </span>
                    </div>
                    <p class="mb-2">Price: ₹<fmt:formatNumber value="${show.price}" pattern="#,##0.00"/></p>
                    <p class="mb-3">Available Seats: ${show.availableSeats}</p>
                    <button type="button" 
                            class="btn btn-success w-100 ${show.availableSeats == 0 ? 'disabled' : ''}"
                            onclick="bookTicket(${show.showId}, ${movie.movieId})"
                            ${show.availableSeats == 0 ? 'disabled' : ''}>
                        ${show.availableSeats == 0 ? 'Sold Out' : 'Book Tickets'}
                    </button>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<script>
function bookTicket(showId, movieId) {
    window.location.href = "${pageContext.request.contextPath}/booking?showId=" + showId + "&movieId=" + movieId;
}
</script>

</body>
</html>