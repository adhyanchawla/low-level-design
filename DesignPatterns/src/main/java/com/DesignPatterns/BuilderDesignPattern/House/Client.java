package main.java.com.DesignPatterns.BuilderDesignPattern.House;

public class Client {
    public static void main(String[]args) {
        Director concHouse1 = new Director(new ConcreteHouseBuilder());
        Director iglooHouse1 = new Director(new IglooHouseBuilder());

        House conceteHouse1 = concHouse1.createHouse();
        conceteHouse1.toString();
        House iglooHouse = iglooHouse1.createHouse();
        iglooHouse.toString();
    }
}
