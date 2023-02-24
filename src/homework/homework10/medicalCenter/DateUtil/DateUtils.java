package homework.homework10.medicalCenter.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");

    private DateUtils() {
    }

    public static Date parseToDate(String date) {
        try {
            return dateFormatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date parseToTime(String time) {
        try {
            return timeFormatter.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String dateToString(Date date) {
        return dateFormatter.format(date);
    }

    public static String timeToString(Date date) {
        return timeFormatter.format(date);
    }

}
