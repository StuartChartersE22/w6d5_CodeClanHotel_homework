package Hotel.RoomTypes;

import People.Guest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    private DiningRoom diningRoom;
    private Guest guest;
    private HashMap<String, Double> menu1;
    private HashMap<String, Double> menu2;

    @Before
    public void before(){
        menu1 = new HashMap<>();
        menu1.put("BLT", 3.50);
        menu1.put("Club", 2.50);
        menu1.put("Coronation chicken", 4.50);
        menu1.put("Steak melt", 6.50);

        menu2 = new HashMap<>();
        menu2.put("Steak and chips", 20.75);
        menu2.put("Cesar salad", 5.35);
        menu2.put("Lasagne", 12.75);

        diningRoom = new DiningRoom(20, menu1);
        guest = new Guest(200.00);
    }

    @Test
    public void diningRoomStartsEmpty(){
        assertEquals(0, diningRoom.getNumberOfOccupants());
    }

    @Test
    public void canGetCapacity(){
        assertEquals(20, diningRoom.getCapacity());
    }

    @Test
    public void canAddGuest(){
        diningRoom.addGuest(guest);
        assertEquals(1, diningRoom.getNumberOfOccupants());
    }

    @Test
    public void canRemoveGuest(){
        diningRoom.addGuest(guest);
        diningRoom.removeGuest(guest);
        assertEquals(0, diningRoom.getNumberOfOccupants());
    }

    @Test
    public void canGetArrayListOfOccupants(){
        diningRoom.addGuest(guest);
        assertEquals(guest, diningRoom.getOccupants().get(0));
    }

    //DINING ROOM SPECIFIC TESTS

    @Test
    public void canGetMenu(){
        assertEquals(menu1, diningRoom.getMenu());
    }

    @Test
    public void canSetMenu(){
        diningRoom.setMenu(menu2);
        assertEquals(menu2, diningRoom.getMenu());
    }

}
