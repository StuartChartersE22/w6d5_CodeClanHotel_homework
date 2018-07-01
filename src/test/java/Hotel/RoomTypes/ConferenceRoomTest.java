package Hotel.RoomTypes;

import Hotel.Booking;
import Hotel.DateHandler;
import People.Guest;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;

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
        String startDatetime = "09-10-2018 at 13:30";
        String endDatetime = "09-10-2018 at 17:30";
        Calendar startDate;
        Calendar endDate;
        startDate = DateHandler.formatForProgram(startDatetime);
        endDate = DateHandler.formatForProgram(endDatetime);
        Booking booking = new Booking(startDate, endDate);
        conferenceRoom.bookRoom(guest, booking);
        assertEquals(startDate, conferenceRoom.getBookings().get(guest).getStartDate());
    }

    // CONFERENCE ROOM SPECIFIC TESTS

    @Test
    public void canGetName(){
        assertEquals("Main", conferenceRoom.getName());
    }

    @Test
    public void canGetRate(){
        assertEquals(35.50, conferenceRoom.getHourlyRate(), 0.001);
    }
}
