package main.java.com.ParkingLot.services;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void paymentMode() {
        System.out.println("Paid in cash");
    }
}
