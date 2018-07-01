package Hotel;

import Hotel.RoomTypes.Bedroom;
import Hotel.RoomTypes.ConferenceRoom;
import Hotel.RoomTypes.DiningRoom;
import People.Guest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

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

    public boolean bookRoomWithTime(Room room, Guest guest, String startDateTime, String endDateTime) {
        Calendar potentialStartDate;
        Calendar potentialEndDate;
        try {
            potentialStartDate = DateHandler.formatForProgram(startDateTime);
            potentialEndDate = DateHandler.formatForProgram(endDateTime);
        } catch (ParseException e) {
            return false;
        }

        Booking potentialBooking = new Booking(potentialStartDate, potentialEndDate);
        long durationInHours = potentialBooking.durationInHours();
        double cost = room.getHourlyRate() * durationInHours;

        if(room.doesBookingOverlap(potentialBooking) || guest.getWallet() < cost){
            return false;
        }

        room.bookRoom(guest, potentialBooking);
        guest.pay(cost);
        return true;
    }

    private long nightsToMillis(int numberOfNights){
        return numberOfNights * (1000 * 60 * 60 *24);
    }

    public boolean bookBedroomForNights(Bedroom bedroom, Guest guest, String startDateTime, int numberOfNights) {
        Calendar potentialStartDate;
        try {
            potentialStartDate = DateHandler.formatForProgram(startDateTime);
        } catch (ParseException e) {
            return false;
        }

        long durationInMillis = nightsToMillis(numberOfNights);

        Booking potentialBooking = new Booking(potentialStartDate, durationInMillis);
        double cost = bedroom.getNightlyRate() * numberOfNights;

        if(bedroom.doesBookingOverlap(potentialBooking) && guest.getWallet() < cost){
            return false;
        }

        bedroom.bookRoom(guest, potentialBooking);
        guest.pay(cost);
        return true;
    }

    public ArrayList<Bedroom> availableBedrooms(Booking potentialBooking){
        ArrayList<Bedroom> availableBedrooms = new ArrayList<>();
        for(Bedroom bedroom : bedrooms){
            if(!bedroom.doesBookingOverlap(potentialBooking)){
                availableBedrooms.add(bedroom);
            }
        }
        return availableBedrooms;
    }
}
