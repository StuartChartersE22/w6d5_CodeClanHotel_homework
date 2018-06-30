package Hotel;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private Booking booking;
    private Calendar startDate;
    private Calendar endDate;
    private String startDatetime;
    private String endDatetime;

    @Before
    public void before() throws ParseException {
        startDatetime = "09-10-2018 at 13:30";
        endDatetime = "09-10-2018 at 17:30";
        startDate = Calendar.getInstance();
        endDate = Calendar.getInstance();
        startDate = DateConversion.formatForProgram(startDatetime);
        endDate = DateConversion.formatForProgram(endDatetime);
        booking = new Booking(startDate, endDate);
    }

    @Test
    public void canGetStartDate(){
        String result = DateConversion.formatForDisplay(booking.getStartDate());
        assertEquals("09-10-2018 at 13:30", result);
    }

    @Test
    public void canGetEndDate(){
        String result = DateConversion.formatForDisplay(booking.getEndDate());
        assertEquals("09-10-2018 at 17:30", result);
    }
}
