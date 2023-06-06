package main.java.com.DesignPatterns.BuilderDesignPattern.House;

public class ConcreteHouseBuilder extends HouseBuilder {
    @Override
    public HouseBuilder setFoundation() {
        this.foundation = "Concrete";
        return this;
    }

    @Override
    public HouseBuilder setStructure() {
        this.structure = "Bricks and mortar";
        return this;
    }

    @Override
    public HouseBuilder setRoof() {
        this.roof = "False ceiling roof";
        return this;
    }

    @Override
    public HouseBuilder setInterior() {
        this.interior = "Luxurious Furniture";
        return this;
    }
}
