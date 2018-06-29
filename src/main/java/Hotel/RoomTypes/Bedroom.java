package Hotel.RoomTypes;

import Hotel.Room;

public class Bedroom extends Room {

    private BedroomTypes type;
    private int number;

    public Bedroom(BedroomTypes type, int number){
        super(type.getCapacity());
        this.type = type;
        this.number = number;
    }

    public BedroomTypes getType() {
        return this.type;
    }

    public int getNumber() {
        return this.number;
    }
}
