// PaymentService.java
package com.bookmyshow.service;

public class PaymentService {
    public boolean processPayment(String cardNumber, String expiryDate, String cvv, double amount) {
        // Mock payment processing
        return cardNumber != null && 
               cardNumber.length() == 16 && 
               expiryDate != null && 
               cvv != null && 
               cvv.length() == 3;
    }
}