package main.java.com.ParkingLot.models;


public class TwoWheelerSlot extends ParkingSlot {

    public TwoWheelerSlot(int floorNo, int slotNo) {
        super(floorNo, slotNo);
    }

    public static double hourlyPrice() {
        return 15;
    }

    public static double minutePrice()  {
        return 0.25;
    }
}
