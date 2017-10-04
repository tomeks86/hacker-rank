import java.util.Scanner;

public class FractionOfInt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] pos_neg_zer = {0, 0, 0};
        String[] numbers = sc.nextLine().split("\\s+");
        int k;
        for (int i = 0; i < n; i++) {
            k = Integer.parseInt(numbers[i]);
            if (k > 0) pos_neg_zer[0]++;
            else if (k < 0) pos_neg_zer[1]++;
            else pos_neg_zer[2]++;
        }
        for (int i = 0; i < 3; i++) {
            System.out.printf("%.6f%n", (float) pos_neg_zer[i] / n);
        }
    }
}
