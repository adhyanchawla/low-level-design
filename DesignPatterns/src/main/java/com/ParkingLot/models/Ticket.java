package main.java.com.ParkingLot.models;

import java.util.Date;

public class Ticket {
    static long ticketId = 0;
    Date entryTime;
    ParkingSlot slot;
    int floor;
    Vehicle vehicle;

    public Ticket(Date entryTime, ParkingSlot slot, int floor, Vehicle vehicle) {
        this.entryTime = entryTime;
        this.slot = slot;
        this.floor = floor;
        this.vehicle = vehicle;
        Ticket.setTicketId();
    }

    public static long getTicketId() {
        return ticketId;
    }

    public static void setTicketId() {
        Ticket.ticketId++;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
