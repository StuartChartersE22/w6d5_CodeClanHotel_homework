package Hotel.RoomTypes;

import People.Guest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    private DiningRoom diningRoom;
    private Guest guest;
    private HashMap<String, Double> menu;

    @Before
    public void before(){
        menu = new HashMap<>();
        menu.put("BLT", 3.50);
        menu.put("Club", 2.50);
        menu.put("Corination chicken", 4.50);
        menu.put("Steak melt", 6.50);
        diningRoom = new DiningRoom(20, menu);
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

}
