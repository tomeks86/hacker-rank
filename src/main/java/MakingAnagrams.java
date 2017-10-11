import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MakingAnagrams {

    public static int numberNeeded(String first, String second) {
        int num = 0;
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            freq1.put(c, (freq1.get(c) == null ? 1 : freq1.get(c) + 1));
        }
        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            freq2.put(c, (freq2.get(c) == null ? 1 : freq2.get(c) + 1));
        }
        Set<Character> chars = new HashSet<>();
        chars.addAll(freq1.keySet());
        chars.addAll(freq2.keySet());
        for (Character aChar : chars) {
            if (freq1.get(aChar) == null) num += freq2.get(aChar);
            else if (freq2.get(aChar) == null) num += freq1.get(aChar);
            else num += Math.abs(freq1.get(aChar) - freq2.get(aChar));
        }
        return num;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();*/
        String a = "cde";
        String b = "abc";
        System.out.println(numberNeeded(a, b));
    }
}
