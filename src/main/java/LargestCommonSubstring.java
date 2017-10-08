import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<int[]> startIndices = new ArrayList<>();
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (table[i][j] == max) {
                    count++;
                    int[] ind = {i, j};
                    startIndices.add(ind);
                }
                if (table[i][j] > max) {
                    max = table[i][j];
                    startIndices = new ArrayList<>();
                    int[] ind = {i, j};
                    startIndices.add(ind);
                    count = 1;
                }
            }
        }
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            StringBuilder res = new StringBuilder("");
            int index = startIndices.get(i)[0] - 1;
            //int index = startIndices.get(i)[1] - 1;
            for (int j = 0; j < max; j++) {
                res.append(s1.substring(index, index + 1));
                //res.append(s2.substring(index, index + 1));
                index--;
            }
            result[i] = res.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "abasfdsbbbb";
        String s2 = "babsssababbbba";
        int[][] table = fillTable(s1,s2);
        //System.out.println(Arrays.deepToString(table));
        String[] LSC = readSequences(s1, s2, table);
        for (String s : LSC) {
            System.out.println(s);
        }
    }
}
