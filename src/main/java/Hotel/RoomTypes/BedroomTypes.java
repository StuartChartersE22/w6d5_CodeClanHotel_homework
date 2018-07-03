package Hotel.RoomTypes;

public enum BedroomTypes {
    DOUBLE(2, 1.00),
    SINGLE(1, 0.50);

    private final int capacity;
    private final double hourlyRate;

    BedroomTypes(int capacity, double hourlyRate){
        this.capacity = capacity;
        this.hourlyRate = hourlyRate;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public double getHourlyRate() {
        return this.hourlyRate;
    }
}
