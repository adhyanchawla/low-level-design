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
    ParkingFloor(int floorNo, int twoWheelerSlots, int fourWheelerSlots, int massiveFourWheelerSlots) {
        this.floorNo = floorNo;
        int totalFloorCapacity = twoWheelerSlots + fourWheelerSlots + massiveFourWheelerSlots;
        this.parkingSlots = new ArrayList<>(totalFloorCapacity);
        int i = 0;
        for(i = 0; i < twoWheelerSlots; i++) {
            this.parkingSlots.add(new TwoWheelerSlot(floorNo, i));
        }

        for(i = i; i < fourWheelerSlots; i++) {
            this.parkingSlots.add(new FourWheelerSlot(floorNo, i));
        }

        for(i = i; i < massiveFourWheelerSlots; i++) {
            this.parkingSlots.add(new MassiveFourWheelerSlot(floorNo, i));
        }
    }
}
