package edu.story;

public class AeroCar {

    private final double size;
    private boolean isInRoom = false;
    private Room room;

    public AeroCar(double size) {
        this.size = size;
    }

    public String movedInsideTheRoom(Room room) {
        if (room != null) {
            if (isInRoom) {
                if (this.room.equals(room))
                    return "Car is in this room";
            }
            if (room.getFreeSpace() < this.size)
                return "Car is too big for this room";
            if (room.addCar(this)) {
                this.room = room;
                room.addCar(this);
                this.isInRoom = true;
                return "Car is in another room";
            }
        }
        return "Can't moved car. Checked yourself.";
    }

    public String movedOutsideTheRoom() {
        if (this.room.removeCar(this)) {
            this.isInRoom = false;
            this.room.removeCar(this);
            return "Car is outside";
        } else
            return "Can't moved car outside. Checked yourself.";
    }

    public double getSize() {
        return size;
    }
}
