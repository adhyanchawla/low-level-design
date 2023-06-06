package main.java.com.DesignPatterns.BuilderDesignPattern.House;

public class House {
    String foundation;
    String structure;
    String roof;
    String interior;

    public House(HouseBuilder houseBuilder) {
        this.foundation = houseBuilder.foundation;
        this.structure = houseBuilder.structure;
        this.roof = houseBuilder.roof;
        this.interior = houseBuilder.interior;
    }

    public String toString() {
        return "" + " Foundation " +  this.foundation +
                " Structure " + this.structure + " Roof "
                + this.roof + " Interior " + this.interior;
    }
}
