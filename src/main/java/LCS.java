import java.util.ArrayList;
import java.util.Scanner;

public class LCS { //Largest Common Subsequence problem
    public static ArrayList<String> LCS(String s1, String s2) {
        ArrayList<String> result = new ArrayList<>();
        int s1L = s1.length();
        int s2L = s2.length();
        if (s2L > s1L) {
            for (int i = 1; i < s1L + 1; i++) { //first try length of 1, then extend
                ArrayList<String> result_tmp = new ArrayList<>();
                for (int j = 0; j < s1L - i + 1; j++) {
                    String test = s1.substring(j, j + i);
                    for (int k = 0; k < s2L - i + 1; k++) {
                        if (s2.substring(k, k + i).compareToIgnoreCase(test) == 0) {
                            if (!result_tmp.contains(test)) {
                                result_tmp.add(test);
                                break;
                            }
                        }
                    }
                }
                if (result_tmp.size() > 0) result = result_tmp;
            }
        } else {
            for (int i = 1; i < s2L + 1; i++) { //first try length of 1, then extend
                ArrayList<String> result_tmp = new ArrayList<>();
                for (int j = 0; j < s2L - i + 1; j++) {
                    String test = s2.substring(j, j + i);
                    for (int k = 0; k < s1L - i + 1; k++) {
                        if (s1.substring(k, k + i).compareToIgnoreCase(test) == 0) {
                            if (!result_tmp.contains(test)) {
                                result_tmp.add(test);
                                break;
                            }
                        }
                    }
                }
                if (result_tmp.size() > 0) result = result_tmp;
            }
        }
        return result;
    }

    public static int LCSlite(String s1, String s2) {
        int result = 0;
        int s1L = s1.length();
        int s2L = s2.length();
        if (s2L > s1L) {
            for (int i = 1; i < s1L + 1; i++) { //first try length of 1, then extend
                for (int j = 0; j < s1L - i + 1; j++) {
                    String test = s1.substring(j, j + i);
                    for (int k = 0; k < s2L - i + 1; k++) {
                        if (s2.substring(k, k + i).compareToIgnoreCase(test) == 0) {
                            result = i;
                            break;
                        }
                    }
                }
            }
        } else {
            for (int i = 1; i < s2L + 1; i++) { //first try length of 1, then extend
                for (int j = 0; j < s2L - i + 1; j++) {
                    String test = s2.substring(j, j + i);
                    for (int k = 0; k < s1L - i + 1; k++) {
                        if (s1.substring(k, k + i).compareToIgnoreCase(test) == 0) {
                            result = i;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static String extendStr(String s, char c, int n) {
        StringBuilder sb = new StringBuilder(s);
        return sb.insert(n, c).toString();
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();*/
        String s1 = "zswcgnrhjroxzlsbkufcnarsyyntvlmefsvbmvoxahqkeasofnqsrmywytzjjamaipisgfgccelgdzbznaynnrrcmrpdwprstwtc";
        String s2 = "uxtmfimpzvhmarltpkzcjtdituvmtbpypwsjyqzkhiqsxetpdgwuobvijndfntzarrrrrtrtinhlqqknehbiakjnglfiudgokzymevjkttpvocifknkddffddvexvvtydazqehjqpswbpzryxthgwyjjaiigvkogjuirghctzmrhurpsfyxrlcfavesxelorgqcoqqee";
        ArrayList<String> LCS = LCS(s1, s2);
        System.out.println(LCS);
        //System.exit(0);
        ArrayList<Character> chars = new ArrayList<>();
        /*for (int i = (int) 'a'; i < (int) 'z' + 1; i++) {
            chars.add((char) i);
        }
        for (int i = (int) '0'; i < (int) '9' + 1; i++) {
            chars.add((char) i);
        }*/
        for (char c : s2.toCharArray()) {
            if (!chars.contains(c)) chars.add(c);
        }

        //System.out.println(LCSlite(s1,s2));
        /*for (Character aChar : chars) {
            System.out.println(aChar);
        }*/
        int len = 0;
        int count = 0;
        if (LCS.size() > 0) {
            len = LCS.get(0).length();
            /*for (Character aChar : chars) {
                for (int i = 0; i < s1.length() + 1; i++) {
                    String test = extendStr(s1, aChar, i);
                    if (LCSlite(test, s2) > len) count++;
                }
            }*/
            for (String lc : LCS) {
                for (Character aChar : chars) {
                    for (int i = 0; i < lc.length() + 1; i++) {
                        String test = extendStr(lc, aChar, i);
                        if (LCSlite(test, s2) > len) count++;
                    }
                }
            }
        } else count = s1.length() + 1;

        System.out.println(count);  //expected 513
    }
}
