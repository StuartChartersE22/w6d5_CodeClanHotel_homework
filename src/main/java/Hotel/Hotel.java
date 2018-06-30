package Hotel;

import Hotel.RoomTypes.Bedroom;
import Hotel.RoomTypes.ConferenceRoom;
import Hotel.RoomTypes.DiningRoom;
import People.Guest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;
    private String name;

    public Hotel(String name, ArrayList<Bedroom> bedrooms){
        this.name = name;
        this.bedrooms = bedrooms;
        this.diningRooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
    }

    public Hotel(String name, ArrayList<Bedroom> bedrooms, ArrayList<DiningRoom> diningRooms) {
        this.name = name;
        this.bedrooms = bedrooms;
        this.diningRooms = diningRooms;
        this.conferenceRooms = new ArrayList<>();
    }

//    public Hotel(String name, ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms){
//        this.name = name;
//        this.bedrooms = bedrooms;
//        this.conferenceRooms = conferenceRooms;
//        this.diningRooms = new ArrayList<>();
//    }

    public Hotel(String name, ArrayList<Bedroom> bedrooms, ArrayList<DiningRoom> diningRooms, ArrayList<ConferenceRoom> conferenceRooms){
        this.name = name;
        this.bedrooms = bedrooms;
        this.diningRooms = diningRooms;
        this.conferenceRooms = conferenceRooms;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return this.bedrooms;
    }

    public ArrayList<DiningRoom> getDiningRooms(){
        return this.diningRooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms(){
        return this.conferenceRooms;
    }

    public ArrayList<Room> getRooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.addAll(this.bedrooms);
        rooms.addAll(this.diningRooms);
        rooms.addAll(this.conferenceRooms);
        return rooms;
    }

    public boolean bookConferenceRoom(ConferenceRoom conferenceRoom, Guest guest, String startDateTime, String endDateTime) {
        Calendar potentialStartDate = Calendar.getInstance();
        Calendar potentialEndDate = Calendar.getInstance();
        try {
            potentialStartDate = DateConversion.formatForProgram(startDateTime);
            potentialEndDate = DateConversion.formatForProgram(endDateTime);
        } catch (ParseException e) {
            return false;
        }

        Booking potentialBooking = new Booking(potentialStartDate, potentialEndDate);
        int durationInMilliseconds = potentialStartDate.compareTo(potentialEndDate);
        int durationInHoursCeiling = (durationInMilliseconds + (1000 * 60 * 60) - 1) / (1000 * 60 * 60);
        double rate = conferenceRoom.getRate() * durationInHoursCeiling;

        if(conferenceRoom.doesBookingOverlap(potentialBooking) && guest.getWallet() < rate){
            return false;
        }
        conferenceRoom.bookRoom(guest, potentialBooking);
        guest.pay(rate);
        return true;
    }
}
