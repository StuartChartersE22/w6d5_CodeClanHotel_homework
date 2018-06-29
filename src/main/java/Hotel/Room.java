package Hotel;

import People.Guest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public abstract class Room {

    private int capacity;
    private ArrayList<Guest> occupants;
    private double rate;
    protected HashMap<Guest, Booking> bookings;

    public Room(int capacity, double rate){
        this.occupants = new ArrayList<>();
        this.capacity = capacity;
        this.rate = rate;
        this.bookings = new HashMap<>();
    }

    public ArrayList<Guest> getOccupants(){
        return this.occupants;
    }

    public int getNumberOfOccupants(){
        return this.occupants.size();
    }

    public void addGuest(Guest guest){
        if(getNumberOfOccupants() < this.capacity) {
            this.occupants.add(guest);
        }
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void removeGuest(Guest guest) {
        this.occupants.remove(guest);
    }

    public boolean isGuestInRoom(Guest guest){
        return occupants.contains(guest);
    }

    public double getRate(){
        return this.rate;
    }


    public void bookRoom(Guest guest, Calendar startDate, Calendar endDate){
        Booking booking = new Booking(startDate, endDate);
        bookings.put(guest, booking);
    }

    public HashMap<Guest, Booking> getBookings() {
        return this.bookings;
    }
}
