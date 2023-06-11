package main.java.com.ParkingLot.services;

import main.java.com.ParkingLot.models.*;

import java.util.List;

public class NearToEntranceParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSlot findParkingSpace(Vehicle vehicle, List<ParkingFloor> floors) {
        ParkingSlot slotAssigned = null;
        String vehicleType = vehicle.getVehicleType().toString();
        for (ParkingFloor floor : floors) {
            List<ParkingSlot> slots = floor.getParkingSlots();
            for (ParkingSlot slot : slots) {
                switch (vehicleType) {
                    case "CAR":
                        if (slot instanceof FourWheelerSlot || slot instanceof MassiveFourWheelerSlot) {
                            if (slot.isFree()) {
                                slotAssigned = slot;
                                break;
                            }
                        }
                        break;
                    case "SCOOTER":
                        if (slot instanceof FourWheelerSlot || slot instanceof TwoWheelerSlot || slot instanceof MassiveFourWheelerSlot) {
                            if (slot.isFree()) {
                                slotAssigned = slot;
                                break;
                            }
                        }
                        break;
                    case "TRUCK":
                        if (slot instanceof MassiveFourWheelerSlot) {
                            if (slot.isFree()) {
                                slotAssigned = slot;
                                break;
                            }
                        }
                        break;
                }
            }
        }
        return slotAssigned;
    }
}
