import java.io.*;
import java.util.*;

public class Diagonals {

    public static int calcDiagSum(int mat[][]) {
        int res = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            res += mat[i][i];
        }
        return res;
    }

    public static int calcAntiDiagSum(int mat[][]) {
        int res = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            res += mat[i][n - i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(line[j]);
            }
        }
        int diff = calcDiagSum(mat) - calcAntiDiagSum(mat);
        diff = (diff > 0) ? diff : -diff;
        System.out.println(diff);
    }
}