package main.java.com.ParkingLot.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingFloor {
    int floorNo;
    List<ParkingSlot> parkingSlots;

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    HashMap<Integer, List<ParkingSlot>> floorSlotsMap = new HashMap<>();

    public int getFloorNo() {
        return floorNo;
    }

    public ParkingFloor(int floorNo, int twoWheelerSlots, int fourWheelerSlots, int massiveFourWheelerSlots) {
        this.floorNo = floorNo;
        int totalFloorCapacity = twoWheelerSlots + fourWheelerSlots + massiveFourWheelerSlots;
        System.out.println("Total capacity " + totalFloorCapacity);
        this.parkingSlots = new ArrayList<>(totalFloorCapacity);
        int i = 0;
        for(i = 0; i < twoWheelerSlots; i++) {
            this.parkingSlots.add(new TwoWheelerSlot(floorNo, i));
        }
        System.out.println(i);
        int currI1 = i;
        for(i = i; i < currI1 + fourWheelerSlots; i++) {
            this.parkingSlots.add(new FourWheelerSlot(floorNo, i));
        }
        System.out.println(i);
        int currI2 = i;
        for(i = i; i < currI2 + massiveFourWheelerSlots; i++) {
            this.parkingSlots.add(new MassiveFourWheelerSlot(floorNo, i));
        }
    }
}
