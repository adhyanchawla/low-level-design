package main.java.com.ParkingLot.models;

import java.util.List;


public abstract class ParkingSlot {
    int parkingSlotId;
    int floorNo;

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
    Vehicle vehicle;

    public ParkingSlot() {

    }

    public ParkingSlot(int floorNo, int parkingSlotId) {
        this.floorNo = floorNo;
        this.parkingSlotId = parkingSlotId;
        this.vehicle = null;
    }



    public int getParkingSlotId() {
        return parkingSlotId;
    }

    public boolean isFree() {
        return this.vehicle == null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setFree(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
