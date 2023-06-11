package main.java.com.ParkingLot.services;

import main.java.com.ParkingLot.models.*;

import java.util.ArrayList;
import java.util.List;

public class RandomParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSlot findParkingSpace(Vehicle vehicle, List<ParkingFloor> floors) {
        int count = 0;
        int range = floors.size();
        ParkingSlot slotAssigned = null;
        int floorNo = -1;
        String vehicleType = String.valueOf(vehicle.getVehicleType());
        System.out.println("Vehicle details " + vehicle.getRegistrationNumber() + " " + vehicleType);
        boolean[] spaceCheck = new boolean[floors.size()];
        while(count < range) {
            int floor = ((int) (Math.random() * range));
            if(spaceCheck[floor])
                continue;
            spaceCheck[floor] = true;
            List<ParkingSlot> slots = floors.get(floor).getParkingSlots();
            List<ParkingSlot> availableSlots = new ArrayList<>();
            for (ParkingSlot slot : slots) {
                switch (vehicleType) {
                    case "CAR":
                        System.out.println("we are here " + vehicleType);
                        if (slot instanceof FourWheelerSlot) {
                            if (slot.isFree()) {
                                availableSlots.add(slot);
                            }
                        }
                        break;
                    case "SCOOTER":
                        if (slot instanceof TwoWheelerSlot) {
                            if (slot.isFree()) {
                                availableSlots.add(slot);
                            }
                        }
                        break;
                    case "TRUCK":
                        if (slot instanceof MassiveFourWheelerSlot) {
                            if (slot.isFree()) {
                                availableSlots.add(slot);
                            }
                        }
                        break;
                }
            }
            if(availableSlots.size() > 0) {
                int slotsSize = availableSlots.size();
                int slot = (int) (Math.random() * slotsSize);
                slotAssigned = availableSlots.get(slot);
                System.out.println("Slot Type " + slotAssigned);
                slotAssigned.setFloorNo(floor);
                floors.get(floor).getParkingSlots().get(slot).setFree(vehicle);
                break;
            } else count++;
        }
        System.out.println(" Is slot assigned null " + (slotAssigned == null));
        if(slotAssigned != null) {
            System.out.println("Slot details inside strategy " + slotAssigned.getParkingSlotId() + " " + slotAssigned.getFloorNo());
        }
        return slotAssigned;
    }
}
