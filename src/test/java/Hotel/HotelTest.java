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
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<DiningRoom> diningRooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

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

        bedrooms = new ArrayList<>();
        diningRooms = new ArrayList<>();
        conferenceRooms = new ArrayList<>();
        diningRooms.add(diningRoom);
        bedrooms.add(bedroom1);
        bedrooms.add(bedroom2);
        conferenceRooms.add(conferenceRoom);

        rooms = new ArrayList<>();
        rooms.addAll(bedrooms);
        rooms.addAll(diningRooms);
        rooms.addAll(conferenceRooms);

        guest = new Guest(200.00);

        hotel = new Hotel ("CodeClan", bedrooms, diningRooms, conferenceRooms);
    }

    @Test
    public void canGetName(){
        assertEquals("CodeClan", hotel.getName());
    }

    @Test
    public void canGetRooms(){
        assertEquals(rooms, hotel.getRooms());
    }

    @Test
    public void canGetBedrooms(){
        assertEquals(bedrooms, hotel.getBedrooms());
    }

    @Test
    public void canGetDiningRooms(){
        assertEquals(diningRooms, hotel.getDiningRooms());
    }

    @Test
    public void canGetConferenceRooms(){
        assertEquals(conferenceRooms, hotel.getConferenceRooms());
    }

    @Test
    public void canMakeHotelWithOnlyBedrooms(){
        Hotel hotel = new Hotel("Le Petite CodeClan",bedrooms);
        assertEquals(bedrooms, hotel.getRooms());
    }

    @Test
    public void canMakeHotelWithBedroomsAndDiningrooms(){
        Hotel hotel = new Hotel("B&B CodeClan", bedrooms, diningRooms);
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.addAll(bedrooms);
        rooms.addAll(diningRooms);
        assertEquals(rooms, hotel.getRooms());
    }

}
