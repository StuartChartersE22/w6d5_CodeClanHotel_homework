package Hotel.RoomTypes;

public enum BedroomTypes {
    DOUBLE(2, 25.50),
    SINGLE(1, 12.00);

    private final int capacity;
    private final double rate;

    BedroomTypes(int capacity, double rate){
        this.capacity = capacity;
        this.rate = rate;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public double getRate(){
        return this.rate;
    }
}
