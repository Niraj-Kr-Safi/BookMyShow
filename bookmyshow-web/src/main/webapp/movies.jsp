<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie Listings</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .movie-card {
            transition: transform 0.3s;
            height: 100%;
            border: 1px solid #ddd;
            margin-bottom: 20px;
        }
        .movie-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        }
        .filter-section {
            background-color: #f8f9fa;
            padding: 20px;
            margin-bottom: 30px;
            border-radius: 8px;
        }
    </style>
</head>
<body>

<div class="container py-5">
    <!-- Filter Section -->
    <div class="filter-section">
        <form method="GET" action="${pageContext.request.contextPath}/movies" class="row g-3">
            <div class="col-md-3">
                <label class="form-label">Genre</label>
                <select name="genre" class="form-select">
                    <option value="">All Genres</option>
                    <c:forEach var="genre" items="${genres}">
                        <option value="<c:out value='${genre}'/>" <c:if test="${selectedGenre == genre}">selected</c:if>>
                            <c:out value="${genre}"/>
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-3">
                <label class="form-label">Language</label>
                <select name="language" class="form-select">
                    <option value="">All Languages</option>
                    <c:forEach var="language" items="${languages}">
                        <option value="<c:out value='${language}'/>" <c:if test="${selectedLanguage == language}">selected</c:if>>
                            <c:out value="${language}"/>
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-3 d-flex align-items-end">
                <button type="submit" class="btn btn-primary">Apply Filters</button>
            </div>
        </form>
    </div>

    <!-- Movies Grid -->
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <c:forEach var="movie" items="${movies}">
            <div class="col">
                <div class="card movie-card">
                    <div class="card-body">
                        <h5 class="card-title"><c:out value="${movie.title}"/></h5>
                        <p class="card-text">
                            <strong>Genre:</strong> <c:out value="${movie.genre}"/><br>
                            <strong>Duration:</strong> <c:out value="${movie.duration}"/> minutes<br>
                            <strong>Language:</strong> <c:out value="${movie.language}"/>
                        </p>
                        <button type="button" 
                                class="btn btn-success" 
                                onclick="bookMovie(${movie.movieId}, '${movie.title}')">
                            Book Now
                        </button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<script>
function bookMovie(movieId, movieTitle) {
    window.location.href = "${pageContext.request.contextPath}/shows?movieId=" + movieId;
}
</script>

</body>
</html>