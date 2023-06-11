package main.java.com.ParkingLot.models;

import java.util.Date;

public class Bill {
    long timeDifference;
    String strategyUsedToCalcPrice;
    double billAmount;
    Date entryTime;
    Date exitTime;

    public Bill(long timeDifference, String strategyUsedToCalcPrice, double billAmount, Date entryTime, Date exitTime) {
        this.timeDifference = timeDifference;
        this.strategyUsedToCalcPrice = strategyUsedToCalcPrice;
        this.billAmount = billAmount;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }
}
