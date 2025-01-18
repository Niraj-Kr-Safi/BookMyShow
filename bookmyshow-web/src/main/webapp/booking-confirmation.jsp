<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- booking-confirmation.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmation</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <h1>Booking Confirmation</h1>
    </header>
    
    <main>
        <section class="confirmation">
            <div class="success-message">
                <h2>Booking Successful!</h2>
                <p>Your booking ID is: ${bookingId}</p>
                <p>Thank you for booking with us.</p>
            </div>
            
            <div class="actions">
                <a href="index.jsp" class="btn">Back to Home</a>
            </div>
        </section>
    </main>
</body>
</html>