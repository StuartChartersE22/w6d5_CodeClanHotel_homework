package Hotel;

import People.Guest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public abstract class Room {

    private int capacity;
    private ArrayList<Guest> occupants;
    private double rate;
    protected HashMap<Guest, Date> bookings;

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


    public boolean bookRoom(Guest guest, String dateString){
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");
        try {
            Date date = datetimeFormat.parse(dateString);
            bookings.put(guest, date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public HashMap<Guest,Date> getBookings() {
        return this.bookings;
    }
}
