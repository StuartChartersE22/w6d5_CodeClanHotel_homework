package Hotel.RoomTypes;

import People.Guest;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BedroomTest {

    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private Guest guest;

    @Before
    public void before(){
        bedroom1 = new Bedroom(BedroomTypes.SINGLE, 1);
        bedroom2 = new Bedroom(BedroomTypes.DOUBLE, 2);
        guest = new Guest(200.00);

    }

    @Test
    public void bedroomStartsEmpty(){
        assertEquals(0, bedroom1.getNumberOfOccupants());
    }

    @Test
    public void canGetCapacity(){
        assertEquals(1, bedroom1.getCapacity());
    }

    @Test
    public void canAddGuest(){
        bedroom1.addGuest(guest);
        assertEquals(1, bedroom1.getNumberOfOccupants());
    }

    @Test
    public void canRemoveGuest(){
        bedroom1.addGuest(guest);
        bedroom1.removeGuest(guest);
        assertEquals(0, bedroom1.getNumberOfOccupants());
    }

    @Test
    public void canGetArrayListOfOccupants(){
        bedroom1.addGuest(guest);
        assertEquals(guest, bedroom1.getOccupants().get(0));
    }

    @Test
    public void canSeeIfaGuestIsInTheRoom(){
        bedroom1.addGuest(guest);
        assertTrue(bedroom1.isGuestInRoom(guest));
    }

    @Test
    public void canSeeIfaGuestIsntInTheRoom(){
        assertFalse(bedroom1.isGuestInRoom(guest));
    }

    // BEDROOM SPECIFIC TESTS

    @Test
    public void canBookRoomWithDate() throws ParseException {
        bedroom1.bookRoom(guest,"09-10-2018");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse("09-10-2018");
        HashMap<Guest, Date> bookings = new HashMap<>();
        bookings.put(guest, date);
        assertEquals(bookings, bedroom1.getBookings());
    }

    @Test
    public void canGetBedroomType(){
        assertEquals(BedroomTypes.SINGLE, bedroom1.getType());
    }

    @Test
    public void canGetBedroomNumber(){
        assertEquals(1, bedroom1.getNumber());
    }

    @Test
    public void canGetBedroomRate(){
        assertEquals(12.00, bedroom1.getRate(), 0.001);
    }
}
