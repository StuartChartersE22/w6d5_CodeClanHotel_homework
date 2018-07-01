package Hotel.RoomTypes;

public enum BedroomTypes {
    DOUBLE(2, 25.50, 10.00),
    SINGLE(1, 12.00, 5.00);

    private final int capacity;
    private final double hourlyRate;
    private final double nightlyRate;

    BedroomTypes(int capacity,double nightlyRate, double hourlyRate){
        this.capacity = capacity;
        this.hourlyRate = hourlyRate;
        this.nightlyRate = nightlyRate;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public double getHourlyRate(){
        return this.hourlyRate;
    }

    public double getNightlyRate() {
        return this.nightlyRate;
    }
}
