import java.text.DateFormatSymbols;
import java.util.*;

public class WeekDay {
    public static String getDay(int day, int month, int year) {
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.US);
        String[] weekdays = dfs.getWeekdays();
        String[] months = dfs.getMonths();
        Calendar calendar = new GregorianCalendar();
        calendar.set(year, month - 1, day);
        return weekdays[calendar.get(Calendar.DAY_OF_WEEK)].toUpperCase();
    }

    public static void main(String[] args) {
        int day = 13;
        int month = 3;
        int year = 1992;
        System.out.println(getDay(day, month, year));
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.UK);
        //Arrays.asList(dfs.getWeekdays()).stream().filter(w -> w != null).forEachOrdered(w -> System.out.println(w));
        String[] weekdays = dfs.getWeekdays();
        for (int i = 1; i < 8; i++) {
            System.out.println(weekdays[i]);
        }
        System.out.println(weekdays.length);
        /*for (String weekday : weekdays) {
            System.out.println(i + " " + weekday);
            i++;
        }*/
    }
}
