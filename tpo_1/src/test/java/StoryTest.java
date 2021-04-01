import edu.story.AeroCar;
import edu.story.Room;
import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class StoryTest {

    private ArrayList<AeroCar> cars = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();

    @Before
    public void setUp() {
        AeroCar car_1 = new AeroCar(45);
        AeroCar car_2 = new AeroCar(90);
        AeroCar car_3 = new AeroCar(145);
        AeroCar car_4 = new AeroCar(556);

        Room bigRoom = new Room(1234);
        Room smallRoom = new Room(666);

        cars.add(car_1);
        cars.add(car_2);
        cars.add(car_3);
        cars.add(car_4);

        rooms.add(bigRoom);
        rooms.add(smallRoom);

        cars.get(0).movedInsideTheRoom(rooms.get(0));
        cars.get(2).movedInsideTheRoom(rooms.get(1));

        System.out.println("FreeSpace in big Room: " + rooms.get(0).getFreeSpace());
        System.out.println("FreeSpace in small Room: " + rooms.get(0).getFreeSpace());
    }


    @Test
    public void whenAddSameCarTwice() {
        System.out.println("Add car with size: " + cars.get(0).getSize());
        assertEquals(cars.get(0).movedInsideTheRoom(rooms.get(0)), "Car is in this room");
        System.out.println(cars.get(0).movedInsideTheRoom(rooms.get(0)));
    }

    @Test
    public void whenAddBigCar() {
        System.out.println("Add car with size: " + cars.get(3).getSize());
        assertEquals(cars.get(3).movedInsideTheRoom(rooms.get(1)), "Car is too big for this room");
        System.out.println(cars.get(3).movedInsideTheRoom(rooms.get(1)));
    }

    @Test
    public void whenAddOneCarInTwoRooms() {
        System.out.println("Add car with size: " + cars.get(2).getSize());
        assertEquals(cars.get(2).movedInsideTheRoom(rooms.get(0)), "Car is in another room");
        assertEquals(cars.get(2).movedInsideTheRoom(rooms.get(1)), "Car is in another room");
        System.out.println(cars.get(2).movedInsideTheRoom(rooms.get(0)));
    }

    @Test
    public void whenRemoveSameCarTwice() {
        System.out.println("Remove car with size: " + cars.get(2).getSize());
        assertEquals(cars.get(2).movedOutsideTheRoom(), "Car is outside");
        assertEquals(cars.get(2).movedOutsideTheRoom(), "Car is already outside");
        System.out.println(cars.get(2).movedOutsideTheRoom());

    }


}