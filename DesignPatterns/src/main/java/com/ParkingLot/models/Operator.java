package main.java.com.ParkingLot.models;

import main.java.com.ParkingLot.services.HourlyPricingStrategy;
import main.java.com.ParkingLot.services.MinutePricingStrategy;
import main.java.com.ParkingLot.services.ParkingStrategy;
import main.java.com.ParkingLot.services.PricingStrategy;

import java.util.Date;
import java.util.List;

public class Operator {
    ParkingStrategy parkingStrategy;
    PricingStrategy pricingStrategy;

    List<ParkingFloor> floors;
    Ticket ticket;
    Bill billCalc;
    public Operator(List<ParkingFloor> floors, ParkingStrategy strategy, PricingStrategy pricingStrategy) {
        this.floors = floors;
        this.parkingStrategy = strategy;
        this.pricingStrategy = pricingStrategy;
    }

    //performs most of the functions at different gates: entry and exit
    public Ticket findParkingSpot(Vehicle vehicle, List<ParkingFloor> floors) {
        System.out.println("We are inside findParkingSpace operator");
        ParkingSlot slot = parkingStrategy.findParkingSpace(vehicle, floors);
        System.out.println(" slot offered " + slot.getParkingSlotId() + " " + slot.getFloorNo());
        if(slot != null) {
            this.ticket = new Ticket(new Date(), slot, slot.getFloorNo(), vehicle);
            System.out.println("Ticket with ticket ID " + Ticket.ticketId +
                    " has been assigned to " + this.ticket.vehicle.getRegistrationNumber());
            return this.ticket;
        } else {
            System.out.println("Parking lot is full for " + vehicle.vehicleType.toString());
            return null;
        }
    }

    double calculateBill(Ticket ticket) {
        System.out.println("Ticket in calc bill is " + (ticket == null));
        this.ticket = ticket;
        if(this.ticket != null) {
            Date exitTime = new Date();
            Date entryTime = this.ticket.getEntryTime();
            long timeDifferenceMillis = exitTime.getTime() - entryTime.getTime();
            // Calculate time difference in minutes
            long timeDifferenceMinutes = timeDifferenceMillis / (60 * 1000);
            // Calculate time difference in hours
            long timeDifferenceHours = timeDifferenceMillis / (60 * 60 * 1000);
            double bill = 0;
            if(pricingStrategy instanceof HourlyPricingStrategy) {
                if(this.ticket.getSlot() instanceof TwoWheelerSlot) {
                    bill = pricingStrategy.getPrice(TwoWheelerSlot.hourlyPrice(), timeDifferenceHours);
                } else if(this.ticket.getSlot() instanceof FourWheelerSlot) {
                    bill = pricingStrategy.getPrice(FourWheelerSlot.hourlyPrice(), timeDifferenceHours);
                } else if(this.ticket.getSlot() instanceof MassiveFourWheelerSlot) {
                    bill = pricingStrategy.getPrice(MassiveFourWheelerSlot.hourlyPrice(), timeDifferenceHours);
                }
                this.billCalc = new Bill(timeDifferenceHours, "Hourly Strategy", bill, entryTime, exitTime);
            } else if(pricingStrategy instanceof MinutePricingStrategy) {
                if(this.ticket.getSlot() instanceof TwoWheelerSlot) {
                    bill = pricingStrategy.getPrice(TwoWheelerSlot.minutePrice(), timeDifferenceMinutes);
                } else if(this.ticket.getSlot() instanceof FourWheelerSlot) {
                    bill = pricingStrategy.getPrice(FourWheelerSlot.minutePrice(), timeDifferenceMinutes);
                } else if(this.ticket.getSlot() instanceof MassiveFourWheelerSlot) {
                    bill = pricingStrategy.getPrice(MassiveFourWheelerSlot.minutePrice(), timeDifferenceMinutes);
                }
                this.billCalc = new Bill(timeDifferenceHours, "Minute Strategy", bill, entryTime, exitTime);
            }
            return bill;
        } else {
            System.out.println("Bill can't be generated since no ticket has been assigned");
            return 0;
        }
    }
    public ParkingSlot removeVehicle(Ticket ticket, List<ParkingFloor> floors) {
        System.out.println("Inside removeVehicle of Operator");
//        this.ticket = ticket;
        if(ticket != null) {
            ParkingSlot assignedSlot = ticket.getSlot();
//            assignedSlot.setFree(null);
            assignedSlot.setFloorNo(null);
            assignedSlot.setFree(null);
            System.out.println("Spot is free? " + assignedSlot.isFree());
//            System.out.println("Floors are " + floors.get(assignedSlot.floorNo).getParkingSlots().get(assignedSlot.getParkingSlotId()).vehicle.getVehicleType());
//            System.out.println(" Position of floors " + floors.get(assignedSlot.floorNo).getParkingSlots().get(assignedSlot.parkingSlotId).isFree());
//            floors.get(assignedSlot.floorNo).getParkingSlots().get(assignedSlot.parkingSlotId).setFree(null);
            System.out.println("Is assigned slot in removeVehicle operator class " + (assignedSlot == null));
            System.out.println(" Assigned Slot " + assignedSlot.parkingSlotId + " " + assignedSlot.getFloorNo());
            return assignedSlot;
        } else {
            System.out.println(" No ticket found ");
            return null;
        }
    }

    public void displayBill() {
        if(this.billCalc == null) {
            System.out.println("Bill cant be calculated since the vehicle has'nt exitted the gate");
        } else {
            System.out.println(" Entry Time " + this.billCalc.entryTime + " Exit Time "
                    + this.billCalc.exitTime + " " + " Amount Paid " + this.billCalc.billAmount
                    + " Time Difference " +  this.billCalc.timeDifference);
        }
    }
}
