package Hotel.RoomTypes;

import Hotel.Room;
import People.Guest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bedroom extends Room {

    private BedroomTypes type;
    private int number;

    public Bedroom(BedroomTypes type, int number){
        super(type.getCapacity(), type.getRate());
        this.type = type;
        this.number = number;
    }

    public BedroomTypes getType() {
        return this.type;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean bookRoom(Guest guest, String dateString){
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = datetimeFormat.parse(dateString);
            bookings.put(guest, date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
