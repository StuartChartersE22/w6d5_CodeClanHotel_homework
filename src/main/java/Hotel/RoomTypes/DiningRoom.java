package Hotel.RoomTypes;

import Hotel.Room;

import java.util.HashMap;

public class DiningRoom extends Room {

    private HashMap<String, Double> menu;

    public DiningRoom(int capacity, HashMap<String, Double> menu){
        super(capacity);
        this.menu = menu;
    }
}
