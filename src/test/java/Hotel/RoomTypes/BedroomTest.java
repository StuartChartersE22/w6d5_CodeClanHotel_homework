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

    @Test
    public void canBookRoomWithDate() throws ParseException {
        String startDatetime = "09-10-2018 at 13:30";
        String endDatetime = "09-10-2018 at 17:30";
        Calendar startDate;
        Calendar endDate;
        startDate = DateHandler.formatForProgram(startDatetime);
        endDate = DateHandler.formatForProgram(endDatetime);
        Booking booking = new Booking(startDate, endDate);
        bedroom1.bookRoom(guest, booking);
        assertEquals(guest, bedroom1.getBookings().get(booking));
    }

    @Test
    public void canRemoveBooking() throws ParseException {
        String startDatetime = "09-10-2018 at 13:30";
        String endDatetime = "09-10-2018 at 17:30";
        Calendar startDate;
        Calendar endDate;
        startDate = DateHandler.formatForProgram(startDatetime);
        endDate = DateHandler.formatForProgram(endDatetime);
        Booking booking = new Booking(startDate, endDate);
        bedroom1.bookRoom(guest, booking);
        bedroom1.cancelBooking(booking);
        assertEquals(0, bedroom1.getBookings().size());
    }

    // BEDROOM SPECIFIC TESTS

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
        assertEquals(5.00, bedroom1.getHourlyRate(), 0.001);
    }
}
