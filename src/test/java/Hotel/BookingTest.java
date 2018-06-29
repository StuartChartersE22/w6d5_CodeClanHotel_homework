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
        startDate.setTime(Config.DATE_FORMAT.parse(startDatetime));
        endDate.setTime(Config.DATE_FORMAT.parse(endDatetime));
        booking = new Booking(startDate, endDate);
    }

    @Test
    public void canGetStartDate(){
        String result = Config.DATE_FORMAT.format(booking.getStartDate().getTime());
        assertEquals("09-10-2018 at 13:30", result);
    }

    @Test
    public void canGetEndDate(){
        String result = Config.DATE_FORMAT.format(booking.getEndDate().getTime());
        assertEquals("09-10-2018 at 17:30", result);
    }
}
