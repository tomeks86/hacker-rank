import com.google.common.collect.Sets;

import java.text.DateFormatSymbols;
import java.util.*;
import java.util.stream.Collectors;

public class LongestCommonSubsequence {
    private static int[][] fillTableLongestCommonSubsequence(String s1, String s2) {
        int[][] result = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) result[i + 1][j + 1] = result[i][j] + 1;
                else result[i + 1][j + 1] = result[i + 1][j] > result[i][j + 1] ? result[i + 1][j] : result[i][j + 1];
            }
        }
        return result;
    }

    private static String readSequenceLongestCommonSubsequence(int[][] table, String s1, String s2){
        StringBuilder res = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        int max = table[i][j];
        while(max > 0) {
            if (s1.charAt(i - 1)== (s2.charAt(j - 1))) {
                res.append(s1.substring(i - 1, i));
                i--;
                j--;
                max -= 1;
            } else {
                if (table[i - 1][j] > table[i][j - 1]) i--;
                else j--;
            }
        }
        return res.reverse().toString();
    }

    public static String longestCommonSubsequence(String s1, String s2) {
        return readSequenceLongestCommonSubsequence(fillTableLongestCommonSubsequence(s1, s2), s1, s2);
    }

    private static int[][] fillTableLongestCommonSubstring(String s1, String s2) {
        int[][] result = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) result[i + 1][j + 1] = result[i][j] + 1;
            }
        }
        return result;
    }

    private static ArrayList<int[]> findMaxIJ(int[][] table) {
        ArrayList<int[]> result = null;
        int max = 0;
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (table[i][j] > max) {
                    result = new ArrayList<>();
                    max = table[i][j];
                    int[] tmp = {i, j};
                    result.add(tmp);
                } else if (table[i][j] == max && result != null) {
                    int[] tmp = {i, j};
                    result.add(tmp);
                }
            }
        }
        return result;
    }

    public static HashSet<String> longestCommonString(String s1, String s2) {
        int[][] table = fillTableLongestCommonSubstring(s1, s2);
        ArrayList<int[]> indices = findMaxIJ(table);
        HashSet<String> result = new HashSet<>();
        for (int[] index : indices) {
            StringBuilder res = new StringBuilder();
            int ind = index[0];
            int len = table[index[0]][index[1]];
            for (int i = 0; i < len; i++) {
                res.append(s1.charAt(ind - 1));
                ind--;
            }
            result.add(res.reverse().toString());
        }
        return result;
    }

    public static int lengthOfTheLongestCommonString(String s1, String s2) {
        int[][] table = fillTableLongestCommonSubstring(s1, s2);
        int max = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] > max) max = table[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = "zswcgnrhjroxzlsbkufcnarsyyntvlmefsvbmvoxahqkeasofnqsrmywytzjjamaipisgfgccelgdzbznaynnrrcmrpdwprstwtc";
        String s2 = "uxtmfimpzvhmarltpkzcjtdituvmtbpypwsjyqzkhiqsxetpdgwuobvijndfntzarrrrrtrtinhlqqknehbiakjnglfiudgokzymevjkttpvocifknkddffddvexvvtydazqehjqpswbpzryxthgwyjjaiigvkogjuirghctzmrhurpsfyxrlcfavesxelorgqcoqqee";
        /*String s1 = "aa";
        String s2 = "baaa";*/
        /*String s1 = "bucefll";
        String s2 = "bdsucacef a l";*/
        String comm = longestCommonSubsequence(s1, s2);
        System.out.println(comm);
        int lenMax = lengthOfTheLongestCommonString(s1, s2);
        //System.out.println(lenMax);
        Set<Character> charsSet = new HashSet();
        for (char c : s2.toCharArray()) {
            charsSet.add(c);
        }

        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        HashSet<String> results = longestCommonString(s1, s2);
        int count = 0;
        for (String result : results) {
            for (char character : charsSet) {
                for (int i = 0; i < result.length() + 1; i++) {
                    StringBuffer sb = new StringBuffer("");
                    String tst = sb.append(result.substring(0,i)).append(character).append(result.substring(i)).toString();
                    if (lengthOfTheLongestCommonString(tst, s2) > lenMax) {
                        System.out.println(tst);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        //System.out.println(Arrays.deepToString(table));
    }
}
