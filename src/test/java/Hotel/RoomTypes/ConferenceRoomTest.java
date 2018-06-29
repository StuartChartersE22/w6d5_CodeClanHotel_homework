package Hotel.RoomTypes;

import People.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom;
    private Guest guest;

    @Before
    public void before(){
        conferenceRoom = new ConferenceRoom(20,"Main", 35.50);
        guest = new Guest(200.00);
    }

    @Test
    public void bedroomStartsEmpty(){
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

    // CONFERENCE ROOM SPECIFIC TESTS

    @Test
    public void canGetName(){
        assertEquals("Main", conferenceRoom.getName());
    }

    @Test
    public void canGetRate(){
        assertEquals(35.50, conferenceRoom.getRate(), 0.001);
    }

    @Test
    public void startsNotBooked(){
        assertFalse(conferenceRoom.isBooked());
    }
}
