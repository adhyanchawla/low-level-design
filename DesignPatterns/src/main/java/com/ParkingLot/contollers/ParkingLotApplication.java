package main.java.com.ParkingLot.contollers;

import main.java.com.ParkingLot.models.*;

import java.util.List;

public class ParkingLotApplication {
    List<EntryGate> entryGates;
    List<ExitGate> exitGates;

    List<ParkingFloor> floors;

    public ParkingLotApplication(List<EntryGate> entryGates, List<ExitGate> exitGates, List<ParkingFloor> floors) {
        this.entryGates = entryGates;
        this.exitGates = exitGates;
        this.floors = floors;
    }
    public Ticket findParkingSpace(int gateId, Vehicle vehicle, List<ParkingFloor> floors) {
            System.out.println("We are inside findParkingSpace controller");
            return this.entryGates.get(gateId).findParkingSpaceAndAllocateSpace(vehicle, gateId, floors);
    }

    public void displayParkingLotStatus() {
        this.entryGates.get(0).displayAvailableSlots(floors);
    }

    public ParkingSlot removeVehicleFromSpace(int gateId, Ticket ticket, List<ParkingFloor> floors) {
        if(!this.exitGates.get(gateId).isGateStatus()) {
            ParkingSlot slot = this.exitGates.get(gateId).removeVehicleFromSpace(ticket, floors);
            this.exitGates.get(gateId).setGateStatus(true);
            double bill = this.exitGates.get(gateId).calculateBill(ticket);
            this.exitGates.get(gateId).displayBill();
            return slot;
        } else {
            System.out.println("Please wait! The gate is currently engaged with another vehicle");
            return null;
        }
    }

    public double calculateBill(int gateId, Ticket ticket) {
        return this.exitGates.get(gateId).calculateBill(ticket);
    }
}
