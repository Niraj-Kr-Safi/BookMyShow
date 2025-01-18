// PaymentServlet.java
package com.bookmyshow.servlet;

import com.bookmyshow.service.PaymentService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
    private PaymentService paymentService = new PaymentService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cardNumber = request.getParameter("cardNumber");
        String expiryDate = request.getParameter("expiryDate");
        String cvv = request.getParameter("cvv");
        double amount = Double.parseDouble(request.getParameter("amount"));
        
        boolean paymentSuccess = paymentService.processPayment(cardNumber, expiryDate, cvv, amount);
        
        if (paymentSuccess) {
            request.getRequestDispatcher("/booking").forward(request, response);
        } else {
            response.sendRedirect("payment.jsp?error=1");
        }
    }
}