package Hotel;

import java.util.Calendar;

public class Booking {
    private Calendar startDate;
    private Calendar endDate;

    public Booking(Calendar startDate, Calendar endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking(Calendar startDate, long duration){
        this.startDate = startDate;
        this.endDate = DateHandler.endDateFromDuration(startDate, duration);
    }

    public Calendar getStartDate() {
        return this.startDate;
    }

    public Calendar getEndDate() {
        return this.endDate;
    }

    public boolean doesDateOverlap(Calendar potentialDate){
        boolean result = false;
        if(this.startDate.before(potentialDate) && this.endDate.after(potentialDate)){
            result = true;
        }
        return result;
    }

    public boolean doesBookingOverlap(Booking potentialBooking){
        boolean result = false;
        Calendar potentialStartDate = potentialBooking.getStartDate();
        Calendar potentialEndDate = potentialBooking.getEndDate();
        if(doesDateOverlap(potentialStartDate) || doesDateOverlap(potentialEndDate)){
            result = true;
        }
        return result;
    }

    public long durationInHours(){
        long durationInMilliseconds = DateHandler.timeBetweenDates(endDate, startDate);
        long durationInHoursCeiling = (durationInMilliseconds + (1000 * 60 * 60) - 1) / (1000 * 60 * 60);
        return durationInHoursCeiling;
    }
}

