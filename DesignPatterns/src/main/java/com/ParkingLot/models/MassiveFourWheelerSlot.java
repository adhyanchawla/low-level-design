package main.java.com.ParkingLot.models;


public class MassiveFourWheelerSlot extends ParkingSlot {
    public MassiveFourWheelerSlot(int floorNo, int slotNo) {
        super(floorNo, slotNo);
    }

    public static double hourlyPrice() {
        return 40;
    }

    public static double minutePrice()  {
        return 1.25;
    }
}
