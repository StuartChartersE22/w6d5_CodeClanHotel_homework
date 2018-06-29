package Hotel;

import Hotel.RoomTypes.Bedroom;
import Hotel.RoomTypes.BedroomTypes;
import Hotel.RoomTypes.ConferenceRoom;
import Hotel.RoomTypes.DiningRoom;
import People.Guest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private Guest guest;
    private ConferenceRoom conferenceRoom;
    private DiningRoom diningRoom;
    private HashMap<String, Double> menu1;
    private Hotel hotel;
    private ArrayList<Room> rooms;

    @Before
    public void before(){

        menu1 = new HashMap<>();
        menu1.put("BLT", 3.50);
        menu1.put("Club", 2.50);
        menu1.put("Coronation chicken", 4.50);
        menu1.put("Steak melt", 6.50);
        diningRoom = new DiningRoom(20, menu1);

        bedroom1 = new Bedroom(BedroomTypes.SINGLE, 1);
        bedroom2 = new Bedroom(BedroomTypes.DOUBLE, 2);

        conferenceRoom = new ConferenceRoom(20,"Main", 35.50);

        rooms = new ArrayList<>();
        rooms.add(diningRoom);
        rooms.add(bedroom1);
        rooms.add(bedroom2);
        rooms.add(conferenceRoom);

        guest = new Guest(200.00);

        hotel = new Hotel ("CodeClan", rooms);
    }

    @Test
    public void canGetName(){
        assertEquals("CodeClan", hotel.getName());
    }

}
