import java.io.*;
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
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
