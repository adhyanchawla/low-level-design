package main.java.com.ParkingLot;

import main.java.com.ParkingLot.models.*;
import main.java.com.ParkingLot.contollers.ParkingLotApplication;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("PR01",
                2,3,3,4,12, 2);
        List<EntryGate> entryGates = parkingLot.getEntryGates();
        List<ExitGate> exitGates = parkingLot.getExitGates();
        List<ParkingFloor> floors = parkingLot.getParkingFloors();
        ParkingLotApplication application = new ParkingLotApplication(entryGates, exitGates, floors);


        //Vehicle 1 enters the parking lot at gate 1
        Vehicle  vehicle1 = new Vehicle("HR04A1234", Vehicle.VehicleType.CAR, "Red");
        Ticket ticket1 = application.findParkingSpace(1, vehicle1, floors);
        System.out.println("Before Vehicle 1 joined");
        application.displayParkingLotStatus();
        if(ticket1 != null) {
            System.out.println("Ticket Assigned in client " + ticket1.getFloor() + " " + ticket1.getSlot() + " " + ticket1.getEntryTime());
        } else {
            System.out.println("Ticket not formed due to technical error");
        }

        ParkingSlot slotAssignedToVacate = application.removeVehicleFromSpace(2, ticket1, floors);
        if(slotAssignedToVacate != null) {
            System.out.println(" Slot status Floor No. " + slotAssignedToVacate.getFloorNo() + " Slot No. " + slotAssignedToVacate.getParkingSlotId() + " is " + slotAssignedToVacate.isFree());
        } else {
            System.out.println("No slot found");
        }
        double bill = application.calculateBill(1, ticket1);
        System.out.println("Bill calc " + bill);
        System.out.println("After Vehicle 1 left");
        application.displayParkingLotStatus();
        // second vehicle joins in
        System.out.println("================================================");

        Vehicle vehicle2 = new Vehicle("HR04A2345", Vehicle.VehicleType.SCOOTER, "Red");
        Ticket ticket2 = application.findParkingSpace(2, vehicle2, floors);
        System.out.println("Before Vehicle 2 joined");
        application.displayParkingLotStatus();
        if(ticket2 != null) {
            System.out.println("Ticket Assigned in client " + ticket2.getFloor() + " " + ticket2.getSlot() + " " + ticket2.getEntryTime());
        } else {
            System.out.println("Ticket not formed due to technical error");
        }

        ParkingSlot slotAssignedToVacate2 = application.removeVehicleFromSpace(2, ticket2, floors);
        if(slotAssignedToVacate2 != null) {
            System.out.println(" Slot status Floor No. " + slotAssignedToVacate2.getFloorNo() + " Slot No. " + slotAssignedToVacate2.getParkingSlotId() + " is " + slotAssignedToVacate2.isFree());
        } else {
            System.out.println("No slot found");
        }
        double bill1 = application.calculateBill(2, ticket2);
        System.out.println("Bill calc " + bill1);
        System.out.println("After Vehicle 2 left");
        application.displayParkingLotStatus();

    }
}
