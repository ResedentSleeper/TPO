package edu.story;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private static AeroCar car;
    private static Room room;
    private static Room newRoom;
    private static Room smallRoom;

    @BeforeAll
    public static void setUp() {
        car = new AeroCar(55);
        room = new Room(70);
        newRoom = new Room(60);
        smallRoom = new Room(6);
        car.movedInsideTheRoom(room);
    }

    @Test
    public void whenAddCarIntoRooms() {
        assertEquals(car.movedInsideTheRoom(newRoom), "Car is in another room");
        assertEquals(car.movedInsideTheRoom(newRoom), "Car is in this room");
        assertEquals(car.movedInsideTheRoom(smallRoom), "Car is too big for this room");
        assertEquals(car.movedInsideTheRoom(null), "Can't moved car. Checked yourself.");

    }

    @Test
    public void whenRemoveCar() {
        assertEquals(car.movedOutsideTheRoom(), "Car is outside");
        assertEquals(car.movedOutsideTheRoom(), "Can't moved car outside. Checked yourself.");

    }
}
