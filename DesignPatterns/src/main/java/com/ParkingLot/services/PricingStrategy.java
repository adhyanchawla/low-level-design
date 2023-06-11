package main.java.com.ParkingLot.services;

import main.java.com.ParkingLot.models.ParkingSlot;

public interface PricingStrategy {
    public double getPrice(double slotPrice, long timeDifference);
}
