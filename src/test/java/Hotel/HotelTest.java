package Hotel;

import Hotel.RoomTypes.Bedroom;
import Hotel.RoomTypes.BedroomTypes;
import Hotel.RoomTypes.ConferenceRoom;
import Hotel.RoomTypes.DiningRoom;
import People.Guest;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    private String startDateTime;
    private String endDateTime;

    @Before
    public void before(){

        menu1 = new HashMap<>();
        menu1.put("BLT", 3.50);
        menu1.put("Club", 2.50);
        menu1.put("Coronation chicken", 4.50);
        menu1.put("Steak melt", 6.50);
        diningRoom = new DiningRoom(20, menu1, 60.00);

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

        startDateTime = "09-10-2018 at 13:30";
        endDateTime = "09-10-2018 at 17:30";

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

    @Test
    public void canBookAConferenceRoom(){
        assertTrue(hotel.bookConferenceRoom(conferenceRoom, guest, 20, startDateTime, endDateTime));
        assertEquals(1, conferenceRoom.getBookings().size());
        assertEquals(58.00, guest.getWallet(), 0.001);
    }

    @Test
    public void cantBookADiningeRoomTooExpensive(){
        assertFalse(hotel.bookDiningRoom(diningRoom, guest, 10, startDateTime, endDateTime));
        assertEquals(0, diningRoom.getBookings().size());
        assertEquals(200.00, guest.getWallet(), 0.001);
    }

    @Test
    public void canBookABedroomFor2Nights(){
        assertTrue(hotel.bookBedroomForNights(bedroom1, guest, 1, startDateTime, 2));
        assertEquals(1, bedroom1.getBookings().size());
        assertEquals(176.00, guest.getWallet(), 0.001);
    }

    @Test
    public void canFindAvailableBedrooms() throws ParseException {
        Calendar startDate = DateHandler.formatForProgram(startDateTime);
        Calendar endDate = DateHandler.formatForProgram(endDateTime);
        Booking potentialBooking = new Booking(startDate, endDate);
        assertEquals(2, hotel.availableBedrooms(potentialBooking, 1).size());
    }

    @Test
    public void canFindAvailableConferenceRooms() throws ParseException {
        Calendar startDate = DateHandler.formatForProgram(startDateTime);
        Calendar endDate = DateHandler.formatForProgram(endDateTime);
        Booking potentialBooking = new Booking(startDate, endDate);
        assertEquals(1, hotel.availableConferenceRoom(potentialBooking, 1).size());
    }

    @Test
    public void canFindAvailableDiningRooms() throws ParseException {
        Calendar startDate = DateHandler.formatForProgram(startDateTime);
        Calendar endDate = DateHandler.formatForProgram(endDateTime);
        Booking potentialBooking = new Booking(startDate, endDate);
        assertEquals(1, hotel.availableDiningRooms(potentialBooking, 1).size());
    }

}
