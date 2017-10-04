public class RedJohnIsBack {
    public static int newton(int N, int K) {
        if (N < K) return -1;
        if (K == 0) return 1;
        if (K > N / 2) K = N - K;
        int numer = 1;
        int denom = 1;
        for (int i = 1; i < K + 1; i++) {
            numer *= (N - i + 1);
            denom *= i;
        }
        return numer / denom;
    }

    /*public static int solNumber(int N) {
        int sol = 0;
        for (int i = 0; i < N / 4; i++) {
            sol += (N - 4*i)
        }
        return sol;
    }*/

    public static void main(String[] args) {
        System.out.println(newton(6,2));
    }
}
