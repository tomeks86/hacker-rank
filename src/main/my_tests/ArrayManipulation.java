import java.util.Arrays;

public class ArrayManipulation {
    static void manipBruteForce(int[] arr, int s, int f, int k) {
        int n = arr.length;
        if (s < 0 || f < 0 || s > n || f > n || f < s) return;
        else {
            for (int i = s - 1; i < f; i++) {
                arr[i] += k;
            }
        }
    }

    static void manipClever(int[] arr, int s, int f, int k) {
        int n = arr.length;
        if (s < 0 || f < 0 || s > n || f > n || f < s) return;
        arr[s - 1] += k;
        arr[f] -= k;
    }

    static int[] readManipClever(int[] arr) {
        int n = arr.length;
        int[] res = new int[n - 1];
        res[0] = arr[0];
        //System.out.print(x + " ");
        for (int i = 1; i < n - 1; i++) {
            res[i] = res[i - 1] + arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arrBF = new int[n];
        int[] arrCL = new int[n + 1];

        manipBruteForce(arrBF, 1, 5, 10);
        manipClever(arrCL, 1, 5, 10);

        manipBruteForce(arrBF, 1, 10, 10);
        manipClever(arrCL, 1, 10, 10);

        manipBruteForce(arrBF, 3, 6, -5);
        manipClever(arrCL, 3, 6, -5);

        manipBruteForce(arrBF, 9, 10, -5);
        manipClever(arrCL, 9, 10, -5);

        manipBruteForce(arrBF, 1, 4, -5);
        manipClever(arrCL, 1, 4, -5);

        manipBruteForce(arrBF, 2, 6, -5);
        manipClever(arrCL, 2, 6, -5);

        manipBruteForce(arrBF, 2, 6, -5);
        manipClever(arrCL, 2, 6, -5);

        manipBruteForce(arrBF, 3, 4, 20);
        manipClever(arrCL, 3, 4, 20);

        System.out.println(Arrays.toString(arrBF));
        System.out.println(Arrays.toString(readManipClever(arrCL)));


        System.out.println(new Object().hashCode());
    }
}
