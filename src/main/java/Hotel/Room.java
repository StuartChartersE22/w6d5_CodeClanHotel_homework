package Hotel;

import People.Guest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public abstract class Room {

    private int capacity;
    private ArrayList<Guest> occupants;
    private double hourlyRate;
    protected HashMap<Guest, Booking> bookings;

    public Room(int capacity, double hourlyRate){
        this.occupants = new ArrayList<>();
        this.capacity = capacity;
        this.hourlyRate = hourlyRate;
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

    public double getHourlyRate(){
        return this.hourlyRate;
    }


    public void bookRoom(Guest guest, Booking booking){
        bookings.put(guest, booking);
    }

    public HashMap<Guest, Booking> getBookings() {
        return this.bookings;
    }

    public boolean doesBookingOverlap(Booking potentialBooking){
        boolean result = false;
        Collection<Booking> currentBookings = this.bookings.values();
        for(Booking booking : currentBookings){
            if(booking.doesBookingOverlap(potentialBooking)){
                result = true;
            }
        }
        return result;
    }
}
