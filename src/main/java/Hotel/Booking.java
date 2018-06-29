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
}

