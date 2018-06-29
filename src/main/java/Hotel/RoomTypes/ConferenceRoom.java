package Hotel.RoomTypes;

import Hotel.Room;

public class ConferenceRoom extends Room {

    private String name;
    private double rate;
    private boolean booked;

    public ConferenceRoom(int capacity, String name, double rate){
        super(capacity);
        this.name = name;
        this.rate = rate;
        this.booked = false;
    }

    public String getName() {
        return this.name;
    }

    public double getRate() {
        return this.rate;
    }


    public boolean isBooked() {
        return this.booked;
    }
}
