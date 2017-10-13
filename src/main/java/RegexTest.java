import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        //String IP = "00.12.123.123123.123";
        String IP = "192.168.0.1";
        //String IP = "255.255.255.255";
        Pattern r = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");
        Matcher m = r.matcher(IP);
        if (m.find()) {
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
            System.out.println(m.group(4));
        }
        System.out.println(IP.matches(new MyRegex().pattern));
    }


    static class MyRegex {
        String zeroTo255 = "(\\d{1,2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])";
        String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." +zeroTo255;
    }
}
