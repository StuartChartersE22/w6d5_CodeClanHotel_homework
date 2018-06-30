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

    public static String formatForDisplay(Calendar date){
        return dateFormat.format(date.getTime());
    }

    public static long timeBetweenDates(Calendar date1, Calendar date2){
        long date1InMillis = date1.getTimeInMillis();
        long date2InMillis = date2.getTimeInMillis();
        return date1InMillis - date2InMillis;
    }
}
