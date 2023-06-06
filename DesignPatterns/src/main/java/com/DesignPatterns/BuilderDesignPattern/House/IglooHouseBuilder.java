package main.java.com.DesignPatterns.BuilderDesignPattern.House;

public class IglooHouseBuilder extends HouseBuilder {
    @Override
    public HouseBuilder setFoundation() {
        this.foundation = "Ice Blocks";
        return this;
    }

    @Override
    public HouseBuilder setStructure() {
        this.structure = "Ice bricks";
        return this;
    }

    @Override
    public HouseBuilder setRoof() {
        this.roof = "Dome shaped ice";
        return this;
    }

    @Override
    public HouseBuilder setInterior() {
        this.interior = "Fur rugs";
        return this;
    }
}
