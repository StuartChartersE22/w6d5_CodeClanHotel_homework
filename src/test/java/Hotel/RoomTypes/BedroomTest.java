package Hotel.RoomTypes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Bedroom bedroom1;
    private Bedroom bedroom2;

    @Before
    public void before(){
        bedroom1 = new Bedroom(BedroomTypes.SINGLE, 1);
        bedroom2 = new Bedroom(BedroomTypes.DOUBLE, 2);
    }

    @Test
    public void bedroomStartsEmpty(){
        assertEquals(0, bedroom1.getNumberOfOccupants());
    }
}
