package main.java.com.ParkingLot.models;

import java.util.List;

public class ExitGate extends Gate {
    int exitGateId;
    boolean gateStatus;
    public ExitGate(int exitGateId, boolean gateStatus, Operator operator) {
        super(exitGateId, gateStatus, operator);
    }

    public ParkingSlot removeVehicleFromSpace(Ticket ticket, List<ParkingFloor> floors) {
        System.out.println(" My operator is null " + (this.operator == null));
        if(this.operator == null) {
            System.out.println("Slot cannot be removed since operator is null");
            return null;
        }


        ParkingSlot slot = operator.removeVehicle(ticket, floors);
        this.setGateStatus(false);
        return slot;
    }

    public double calculateBill(Ticket ticket) {
        return operator.calculateBill(ticket);
    }

    public boolean isGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(boolean gateStatus) {
        this.gateStatus = gateStatus;
    }

    public void displayBill() {
        operator.displayBill();
    }
}
