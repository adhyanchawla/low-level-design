package main.java.com.ParkingLot.services;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void paymentMode() {
        System.out.println("Paid via card");
    }
}
