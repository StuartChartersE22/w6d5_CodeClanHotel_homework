package People;

import Hotel.RoomTypes.Bedroom;
import Hotel.RoomTypes.BedroomTypes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

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
    public void canGetWallet(){
        assertEquals(200.00, guest.getWallet(), 0.001);
    }

    @Test
    public void canRemoveMoney(){
        double roomPrice = bedroom1.getRate();
        guest.pay(roomPrice);
        assertEquals(188.00, guest.getWallet(), 0.001);
    }

}
