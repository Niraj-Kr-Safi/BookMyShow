<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Tickets</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title mb-0">Book Tickets</h3>
                    </div>
                    <div class="card-body">
                        <form action="booking" method="post">
                            <input type="hidden" name="showId" value="${show.showId}">
                            
                            <div class="mb-3">
                                <label class="form-label">Show Time</label>
                                <p class="form-control-static">
                                    <c:if test="${not empty showDateTime}">
                                        <fmt:parseDate value="${showDateTime}" pattern="yyyy-MM-dd HH:mm:ss" var="parsedDate" />
                                        <fmt:formatDate value="${parsedDate}" pattern="EEE, MMM d, yyyy hh:mm a"/>
                                    </c:if>
                                </p>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">Price per Ticket</label>
                                <p class="form-control-static">
                                    ₹<fmt:formatNumber value="${show.price}" pattern="#,##0.00"/>
                                </p>
                            </div>
                            
                            <div class="mb-3">
                                <label for="numberOfSeats" class="form-label">Number of Seats</label>
                                <select class="form-select" id="numberOfSeats" name="numberOfSeats" required>
                                    <c:forEach begin="1" end="10" var="i">
                                        <option value="${i}">${i}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            
                            <button type="submit" class="btn btn-primary w-100">Proceed to Payment</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>