package main.java.com.DesignPatterns.BuilderDesignPattern.House;

public class TreeHouseBuilder extends HouseBuilder {
    @Override
    public HouseBuilder setFoundation() {
        this.foundation = "Wooden poles";
        return this;
    }

    @Override
    public HouseBuilder setStructure() {
        this.structure = "Wood and rope";
        return this;
    }

    @Override
    public HouseBuilder setRoof() {
        this.roof = "Leaf thatched";
        return this;
    }

    @Override
    public HouseBuilder setInterior() {
        this.interior = "Swinging hammocks";
        return this;
    }
}
