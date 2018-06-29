package Hotel.RoomTypes;

import People.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        bedroom1.addOccupant(guest);
        assertEquals(1, bedroom1.getNumberOfOccupants());
    }

    @Test
    public void canGetArrayListOfOccupants(){
        bedroom1.addOccupant(guest);
        assertEquals(guest, bedroom1.getOccupants().get(0));
    }
}
