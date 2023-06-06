package main.java.com.DesignPatterns.BuilderDesignPattern.House;

public class Director {
    private HouseBuilder houseBuilder;

    public Director(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House createHouse() {
        if(houseBuilder instanceof IglooHouseBuilder) {
            System.out.println("called here i");
            return createIglooHouse();
        } else if(houseBuilder instanceof TreeHouseBuilder) {
            System.out.println("called here t");
            return createTreeHouse();
        } else if(houseBuilder instanceof ConcreteHouseBuilder) {
            System.out.println("called here c");
            return createConcreteHouse();
        }
        return null;
    }

    public House createIglooHouse() {
        return houseBuilder.setFoundation().setInterior().build();
    }

    public House createTreeHouse() {
        return houseBuilder.setFoundation().build();
    }

    public House createConcreteHouse() {
        return houseBuilder.setStructure().setRoof().setInterior().setFoundation().build();
    }
}
