import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TimeConversion {

    static String timeConversion(String s) {
        StringBuffer sb = new StringBuffer();
        int addition = 0;
        String PM = s.substring(8,10);
        int hour = Integer.parseInt(s.substring(0,2));
        int minutes = Integer.parseInt(s.substring(3,5));
        int seconds = Integer.parseInt(s.substring(6,8));
        if (PM.compareTo("PM") == 0) {
            if (hour != 12) addition = 12;
        } else if (hour == 12) addition = 12;
        hour += addition;
        hour %= 24;
        String hourStr = String.valueOf(hour);
        hourStr = ("00" + hourStr).substring(hourStr.length());
        sb.append(hourStr);
        sb.append(s.substring(2,8));
        return sb.toString();
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        String s = in.next();*/
        String s = "12:00:01AM";
        String result = timeConversion(s);
        System.out.println(result);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(time.format(DateTimeFormatter.ofPattern("hh:mm:ssa")));
        //String test = time.format(DateTimeFormatter.ofPattern("hh:mm:ssa"));
        //System.out.println(timeConversion(test));
        LocalTime time2 = LocalTime.parse(s, DateTimeFormatter.ofPattern("hh:mm:ssa"));
        System.out.println();
        System.out.println(time2.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
