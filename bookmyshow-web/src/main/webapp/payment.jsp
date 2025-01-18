<!-- payment.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Payment - BookMyShow</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <h1>Payment Details</h1>
    </header>
    
    <main>
        <section class="payment-form">
            <form action="payment" method="POST" onsubmit="return validatePayment()">
                <input type="hidden" name="amount" value="${param.amount}">
                
                <div class="form-group">
                    <label for="cardNumber">Card Number:</label>
                    <input type="text" id="cardNumber" name="cardNumber" maxlength="16" required>
                </div>
                
                <div class="form-group">
                    <label for="expiryDate">Expiry Date:</label>
                    <input type="text" id="expiryDate" name="expiryDate" placeholder="MM/YY" maxlength="5" required>
                </div>
                
                <div class="form-group">
                    <label for="cvv">CVV:</label>
                    <input type="password" id="cvv" name="cvv" maxlength="3" required>
                </div>
                
                <div class="form-group">
                    <label>Amount to Pay:</label>
                    <span class="amount">$${param.amount}</span>
                </div>
                
                <button type="submit" class="btn">Pay Now</button>
            </form>
        </section>
    </main>
    
    <script>
        function validatePayment() {
            const cardNumber = document.getElementById('cardNumber').value;
            const expiryDate = document.getElementById('expiryDate').value;
            const cvv = document.getElementById('cvv').value;
            
            if (!/^\d{16}$/.test(cardNumber)) {
                alert('Please enter a valid 16-digit card number');
                return false;
            }
            
            if (!/^\d{2}\/\d{2}$/.test(expiryDate)) {
                alert('Please enter a valid expiry date (MM/YY)');
                return false;
            }
            
            if (!/^\d{3}$/.test(cvv)) {
                alert('Please enter a valid 3-digit CVV');
                return false;
            }
            
            return true;
        }
    </script>
</body>
</html>