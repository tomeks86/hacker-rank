import java.util.Arrays;

public class LargestCommonSubstring {
    private static int[][] fillTable(String s1, String s2) {
         int[][] result = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++) {
            Character s1c = s1.charAt(i - 1);
            for (int j = 1; j < s2.length() + 1; j++) {
                Character s2c = s2.charAt(j - 1);
                if (s1c.compareTo(s2c) == 0) {
                    result[i][j] = result[i-1][j-1] + 1;
                }
            }
        }
        return result;
    }

    private static String[] readSequences(String s1, String s2, int[][]table) {
        int max = 0;
        int count = 0;
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (table[i][j] == max) count++;
                if (table[i][j] > max) {
                    max = table[i][j];
                    count = 1;
                }
            }
        }
        System.out.println(max + " " + count);
        return null;
    }

    public static void main(String[] args) {
        String s1 = "abab";
        String s2 = "baba";
        int[][] table = fillTable(s1,s2);
        System.out.println(Arrays.deepToString(table));
        readSequences(s1, s2, table);
    }
}
