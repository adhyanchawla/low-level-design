package main.java.com.ParkingLot.models;

import java.util.List;


public class ParkingSlot {
    int parkingSlotId;
    Integer floorNo;

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }
    Vehicle vehicle;

    public ParkingSlot() {

    }

    public ParkingSlot(int floorNo, int parkingSlotId) {
        this.floorNo = floorNo;
        this.parkingSlotId = parkingSlotId;
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
}
