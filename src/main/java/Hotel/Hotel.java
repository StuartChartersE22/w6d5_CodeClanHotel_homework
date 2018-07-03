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

    private <T extends Room> boolean bookRoom(T room, Guest guest, int numberOfPeople, Booking potentialBooking, ArrayList<T> rooms) {

        long durationInHours = potentialBooking.durationInHours();
        double cost = room.getRate() * durationInHours;

        if(!availableRooms(potentialBooking, numberOfPeople, rooms).contains(room) || guest.getWallet() < cost){
            return false;
        }

        room.bookRoom(guest, potentialBooking);
        guest.pay(cost);
        return true;
    }

    private long nightsToMillis(int numberOfNights){
        return numberOfNights * (1000 * 60 * 60 *24);
    }

    public boolean bookConferenceRoom(ConferenceRoom conferenceRoom, Guest guest, int numberOfGuests, String startDateTime, String endDateTime){
        Calendar potentialStartDate;
        Calendar potentialEndDate;
        try {
            potentialStartDate = DateHandler.formatForProgram(startDateTime);
            potentialEndDate = DateHandler.formatForProgram(endDateTime);
        } catch (ParseException e) {
            return false;
        }

        Booking potentialBooking = new Booking(potentialStartDate, potentialEndDate);

        return bookRoom(conferenceRoom, guest, numberOfGuests, potentialBooking, conferenceRooms);

    }

    public boolean bookDiningRoom(DiningRoom diningRoom, Guest guest, int numberOfGuests, String startDateTime, String endDateTime){
        Calendar potentialStartDate;
        Calendar potentialEndDate;
        try {
            potentialStartDate = DateHandler.formatForProgram(startDateTime);
            potentialEndDate = DateHandler.formatForProgram(endDateTime);
        } catch (ParseException e) {
            return false;
        }

        Booking potentialBooking = new Booking(potentialStartDate, potentialEndDate);

        return bookRoom(diningRoom, guest, numberOfGuests, potentialBooking, diningRooms);

    }

    public boolean bookBedroomForNights(Bedroom bedroom, Guest guest, int numberOfGuests, String startDateTime, int numberOfNights) {
        Calendar potentialStartDate;
        try {
            potentialStartDate = DateHandler.formatForProgram(startDateTime);
        } catch (ParseException e) {
            return false;
        }

        long durationInMillis = nightsToMillis(numberOfNights);

        Booking potentialBooking = new Booking(potentialStartDate, durationInMillis);

        return bookRoom(bedroom, guest, numberOfGuests, potentialBooking, bedrooms);
    }

    private <T extends Room> ArrayList<T> availableRooms(Booking potentialBooking, int numberOfPeople, ArrayList<T> rooms){
        ArrayList<T> availableBedrooms = new ArrayList<>();
        for(T room : rooms){
            if(!room.doesBookingOverlap(potentialBooking) && numberOfPeople <= room.getCapacity()){
                availableBedrooms.add(room);
            }
        }
        return availableBedrooms;
    }

    public ArrayList<Bedroom> availableBedrooms(Booking potentialBooking, int numberOfPeople){
        return availableRooms(potentialBooking, numberOfPeople, bedrooms);
        }

    public ArrayList<DiningRoom> availableDiningRooms(Booking potentialBooking, int numberOfPeople){
        return availableRooms(potentialBooking, numberOfPeople, diningRooms);
        }

    public ArrayList<ConferenceRoom> availableConferenceRoom(Booking potentialBooking, int numberOfPeople){
        return availableRooms(potentialBooking, numberOfPeople, conferenceRooms);
        }
    }
