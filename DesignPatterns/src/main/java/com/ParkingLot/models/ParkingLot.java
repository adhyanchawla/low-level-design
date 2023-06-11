package main.java.com.ParkingLot.models;

import main.java.com.ParkingLot.services.HourlyPricingStrategy;
import main.java.com.ParkingLot.services.RandomParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    List<ParkingFloor> parkingFloors;
    List<EntryGate> entryGates;
    List<ExitGate> exitGates;

    public ParkingLot(String parkingLotId, int parkingFloors, int entryGates, int exitGates, int twoWheelerSlots, int fourWheelerSlots, int massiveFourWheelerSlots) {
        createParkingLot(parkingLotId, parkingFloors, entryGates, exitGates, twoWheelerSlots, fourWheelerSlots, massiveFourWheelerSlots);
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public List<ExitGate> getExitGates() {
        return exitGates;
    }

    public void createParkingLot(String parkingLotId, int parkingFloors, int entryGates, int exitGates, int twoWheelerSlots, int fourWheelerSlots, int massiveFourWheelerSlots) {
        this.parkingLotId = parkingLotId;

        //initalize parking floors
        this.parkingFloors = new ArrayList<>(parkingFloors);
        for(int i = 0; i < parkingFloors; i++) {
            this.parkingFloors.add(new ParkingFloor(i, twoWheelerSlots, fourWheelerSlots, massiveFourWheelerSlots));
        }

        //initialize entry gates
        this.entryGates = new ArrayList<>(entryGates);
        for(int i = 0; i < entryGates; i++) {
            this.entryGates.add(new EntryGate(i, false, new Operator(this.parkingFloors, new RandomParkingStrategy(), new HourlyPricingStrategy())));
        }

        //initialize exit gates
        this.exitGates = new ArrayList<>(exitGates);
        for(int i = 0; i < exitGates; i++) {
            System.out.println("Exit Gate created " + i);
            this.exitGates.add(new ExitGate(i, false, new Operator(this.parkingFloors, new RandomParkingStrategy(), new HourlyPricingStrategy())));
        }
    }
}
