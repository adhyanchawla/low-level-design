package main.java.com.ParkingLot.models;

public class FourWheelerSlot extends ParkingSlot{
    public FourWheelerSlot(int floorNo, int slotNo) {
        super(floorNo, slotNo);
    }

    public static double hourlyPrice() {
        return 25;
    }

    public static double minutePrice()  {
        return 0.5;
    }
}
