package Hotel;

import java.util.Calendar;

public class Booking {
    private Calendar startDate;
    private Calendar endDate;

    public Booking(Calendar startDate, Calendar endDate){
        this.startDate = startDate;
        this.endDate = endDate;
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
}

