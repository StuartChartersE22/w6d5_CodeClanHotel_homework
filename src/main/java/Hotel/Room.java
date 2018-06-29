package Hotel;

import People.Guest;

import java.util.ArrayList;

public abstract class Room {

    protected int capacity;
    private ArrayList<Guest> occupants;

    public Room(int capacity){
        this.occupants = new ArrayList<>();
        this.capacity = capacity;
    }

    public ArrayList<Guest> getOccupants(){
        return this.occupants;
    }

    public int getNumberOfOccupants(){
        return this.occupants.size();
    }

    public void addOccupant(Guest guest){
        if(getNumberOfOccupants() < this.capacity) {
            occupants.add(guest);
        }
    }

    public int getCapacity(){
        return this.capacity;
    }
}
