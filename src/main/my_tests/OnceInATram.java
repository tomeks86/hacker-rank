import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class OnceInATram {

    static String onceInATram(int x) {
        // Complete this function; aaabbb
        while (x < 10e6) {
            x++;
            if (isLucky(x)) break;
        }
        return Integer.toString(x);
    }

    private static boolean isLucky(int x) { //aaabbb
        int a = x / 1000;
        int b = x - x / 1000 * 1000;
        if (digitSum(a) == digitSum(b)) return true;
        return false;
    }

    private static int digitSum(int x) {
        int sum = 0;
        String X = String.valueOf(x);
        for (int i = 0; i < X.length(); i++) {
            sum += Character.digit(X.charAt(i), 10);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        if (x > 99999 && x < 999999) {
            String result = onceInATram(x);
            System.out.println(result);
        }
    }
}