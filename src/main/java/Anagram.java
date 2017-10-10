import java.util.HashMap;
import java.util.StringTokenizer;

public class Anagram {
    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if (s1.length() != s2.length()) return false;
        else {
            HashMap<Character, Integer> res1 = new HashMap<>();
            HashMap<Character, Integer> res2 = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                res1.put(c, (res1.get(c) == null) ? 1 : res1.get(c) + 1);
                c = s2.charAt(i);
                res2.put(c, (res2.get(c) == null) ? 1 : res2.get(c) + 1);
            }
            if (res1.keySet().size() != res2.keySet().size()) return false;
            else {
                for (Character character : res1.keySet()) {
                    if (res1.get(character) != res2.get(character)) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aalaa";
        String s2 = "alaaa";
        HashMap<Character, Integer> test = new HashMap<>();
        System.out.println(test.get('a'));
        test.put('a', 5);
        System.out.println(test.get('a'));
        System.out.println(isAnagram(s1, s2));
        StringTokenizer st = new StringTokenizer("abc def", "\\");
        System.out.println(st.countTokens());
        s1 = s1.replace("^\\s+","");
        System.out.println(s1.length());
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
