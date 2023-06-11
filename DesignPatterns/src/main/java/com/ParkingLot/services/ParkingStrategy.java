package main.java.com.ParkingLot.services;

import main.java.com.ParkingLot.models.ParkingFloor;
import main.java.com.ParkingLot.models.ParkingSlot;
import main.java.com.ParkingLot.models.Vehicle;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSlot findParkingSpace(Vehicle vehicle, List<ParkingFloor> floors);
}
