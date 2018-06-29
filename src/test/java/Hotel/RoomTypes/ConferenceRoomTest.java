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

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom;
    private Guest guest;

    @Before
    public void before(){
        conferenceRoom = new ConferenceRoom(20,"Main", 35.50);
        guest = new Guest(200.00);
    }

    @Test
    public void conferenceRoomStartsEmpty(){
        assertEquals(0, conferenceRoom.getNumberOfOccupants());
    }

    @Test
    public void canGetCapacity(){
        assertEquals(20, conferenceRoom.getCapacity());
    }

    @Test
    public void canAddGuest(){
        conferenceRoom.addGuest(guest);
        assertEquals(1, conferenceRoom.getNumberOfOccupants());
    }

    @Test
    public void canRemoveGuest(){
        conferenceRoom.addGuest(guest);
        conferenceRoom.removeGuest(guest);
        assertEquals(0, conferenceRoom.getNumberOfOccupants());
    }

    @Test
    public void canGetArrayListOfOccupants(){
        conferenceRoom.addGuest(guest);
        assertEquals(guest, conferenceRoom.getOccupants().get(0));
    }

    @Test
    public void canSeeIfaGuestIsInTheRoom(){
        conferenceRoom.addGuest(guest);
        assertTrue(conferenceRoom.isGuestInRoom(guest));
    }

    @Test
    public void canSeeIfaGuestIsntInTheRoom(){
        assertFalse(conferenceRoom.isGuestInRoom(guest));
    }

    @Test
    public void canBookRoomWithDate() throws ParseException {
        conferenceRoom.bookRoom(guest,"09-10-2018 at 13:30");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");
        Date date = dateFormat.parse("09-10-2018 at 13:30");
        HashMap<Guest, Date> bookings = new HashMap<>();
        bookings.put(guest, date);
        assertEquals(bookings, conferenceRoom.getBookings());
    }

    // CONFERENCE ROOM SPECIFIC TESTS

    @Test
    public void canGetName(){
        assertEquals("Main", conferenceRoom.getName());
    }

    @Test
    public void canGetRate(){
        assertEquals(35.50, conferenceRoom.getRate(), 0.001);
    }
}
