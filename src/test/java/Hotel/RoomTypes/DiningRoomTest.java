package Hotel.RoomTypes;

import Hotel.Config;
import People.Guest;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        diningRoom = new DiningRoom(20, menu1, 60.00);
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

    @Test
    public void canSeeIfaGuestIsInTheRoom(){
        diningRoom.addGuest(guest);
        assertTrue(diningRoom.isGuestInRoom(guest));
    }

    @Test
    public void canSeeIfaGuestIsntInTheRoom(){
        assertFalse(diningRoom.isGuestInRoom(guest));
    }

    @Test
    public void canBookRoomWithDate() throws ParseException {
        String startDatetime = "09-10-2018 at 13:30";
        String endDatetime = "09-10-2018 at 17:30";
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(Config.DATE_FORMAT.parse(startDatetime));
        endDate.setTime(Config.DATE_FORMAT.parse(endDatetime));
        diningRoom.bookRoom(guest, startDate, endDate);
        assertEquals(startDate, diningRoom.getBookings().get(guest).getStartDate());
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
