package main.java.com.ParkingLot.models;

public class Vehicle {
    String registrationNumber;
    VehicleType vehicleType;
    String color;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public enum VehicleType {
        CAR,
        SCOOTER,
        TRUCK
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public Vehicle(String registrationNumber, VehicleType vehicleType, String color) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.color = color;
    }
}
