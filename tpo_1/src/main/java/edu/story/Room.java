package edu.story;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private double freeSpace;
    private List<AeroCar> cars = new ArrayList<>();

    public Room(double freeSpace) {
        this.freeSpace = freeSpace;
    }

    protected boolean addCar(AeroCar car) {
        if (this.freeSpace < car.getSize())
            return false;
        this.freeSpace -= car.getSize();
        this.cars.add(car);
        return true;
    }

    protected boolean removeCar(AeroCar car) {
        if (!this.cars.contains(car))
            return false;
        this.freeSpace += car.getSize();
        this.cars.remove(car);
        return true;
    }

    public double getFreeSpace() {
        return freeSpace;
    }

}
