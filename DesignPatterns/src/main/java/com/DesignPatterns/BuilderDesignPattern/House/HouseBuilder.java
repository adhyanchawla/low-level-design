package main.java.com.DesignPatterns.BuilderDesignPattern.House;

public abstract class HouseBuilder {
    String foundation;
    String structure;
    String roof;
    String interior;

    public abstract HouseBuilder setFoundation();
    public abstract HouseBuilder setStructure();
    public abstract HouseBuilder setRoof();
    public abstract HouseBuilder setInterior();

    public House build() {
        return new House(this);
    }
}
