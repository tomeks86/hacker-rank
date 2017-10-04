import java.util.Scanner;

public class Sums {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long min, max;
        long sum = 0;
        for (int i = 1; i < 5; i++) {
            sum += arr[i];
        }
        min = sum;
        max = sum;
        for (int i = 1; i < 5; i++) {
            sum = 0;
            for (int j = 0; j < 5; j++) {
                if (j == i) continue;
                sum += arr[j];
            }
            if (sum > max) max = sum;
            if (sum < min) min = sum;
        }
        System.out.println(min + " " + max);
    }
}
