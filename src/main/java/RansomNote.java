import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {
    static boolean isOK(String[] magazine, String[] ransom) {
        HashMap<String, Integer> magazineWordCount = new HashMap<>();
        HashMap<String, Integer> ransomWordCount = new HashMap<>();
        for (String str : magazine) {
            magazineWordCount.put(str, (magazineWordCount.get(str) == null) ? 1 : magazineWordCount.get(str) + 1);
        }
        for (String str : ransom) {
            ransomWordCount.put(str, (ransomWordCount.get(str) == null) ? 1 : ransomWordCount.get(str) + 1);
        }
        for (String s : ransomWordCount.keySet()) {
            if (magazineWordCount.get(s) == null) return false;
            if (magazineWordCount.get(s) < ransomWordCount.get(s)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();*/
        /*String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }*/
        String[] magazine = "two times three is not four".split("\\s+");
        String[] ransom = "two times two is four".split("\\s+");

        System.out.println(isOK(magazine, ransom));
    }
}