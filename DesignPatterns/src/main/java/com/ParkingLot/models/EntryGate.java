package main.java.com.ParkingLot.models;

import java.util.ArrayList;
import java.util.List;

public class EntryGate extends Gate {
    int entryGateId;
    boolean gateStatus;

    public EntryGate(int entryGateId, boolean gateStatus, Operator operator) {
        super(entryGateId, gateStatus, operator);
    }

    public boolean isGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(boolean gateStatus) {
        this.gateStatus = gateStatus;
    }

    public Ticket findParkingSpaceAndAllocateSpace(Vehicle vehicle, int entryGateId, List<ParkingFloor> floors) {
        System.out.println("We are inside findParkingSpace entry gate");
        Ticket ticket = operator.findParkingSpot(vehicle, floors);
        setGateStatus(false);
        System.out.println(" Gate " + entryGateId + " is free!");
        return ticket;
    }

    public int getEntryGateId() {
        return entryGateId;
    }

    public void setEntryGateId(int entryGateId) {
        this.entryGateId = entryGateId;
    }

    public static void displayAvailableSlots(List<ParkingFloor> floors) {
//        List<ParkingFloor> floors = this.parkingFloors;
        for (ParkingFloor floor : floors) {
            List<ParkingSlot> slots = floor.getParkingSlots();
            int availableTwoWheelerSlots = 0, availableFourWheelerSlots = 0, availableMassiveFourWheelerSlots = 0;
            for (ParkingSlot slot : slots) {
                if (slot instanceof TwoWheelerSlot) {
                    if (slot.isFree())
                        availableTwoWheelerSlots++;
                } else if (slot instanceof FourWheelerSlot) {
                    if (slot.isFree()) {
                        availableFourWheelerSlots++;
                    }
                } else if (slot instanceof MassiveFourWheelerSlot) {
                    availableMassiveFourWheelerSlots++;
                }
            }
            System.out.println(" Floor Number " + floor.floorNo + " TwoWheelerSlots Available " +
                    availableTwoWheelerSlots + " FourWheelerSlots Available " + availableFourWheelerSlots
                    + " MassiveFourWheelerSlots Available " + availableMassiveFourWheelerSlots);
        }
    }

}
