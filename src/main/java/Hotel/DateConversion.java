package Hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConversion {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");

    public static Calendar formatForProgram(String dateTime) throws ParseException {
        Date dateDate = dateFormat.parse(dateTime);
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(dateDate);
        return calendarDate;
    }

    public static final String formatForDisplay(Calendar date){
        return dateFormat.format(date.getTime());
    }
}
