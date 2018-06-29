package Hotel;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;
    private String name;

    public Hotel(String name, ArrayList<Room> rooms){
        this.name = name;
        this.rooms = rooms;
    }

    public Object getName() {
        return this.name;
    }
}
