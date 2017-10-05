import java.util.Arrays;
import java.util.Scanner;

public class RedJohnIsBack {
    public static int[] primes(int n) {
        boolean[] tab = new boolean[n-1];   //0 -> number 2, 1 -> number 3, ... n-2 -> number n
        int k = n - 1;  //first numbers count
        for (int i = 0; i < Math.sqrt(n) - 1; i++) {
            if (!tab[i]) {
                int isq = (i + 2) * (i + 3) - (i + 2);
                while (isq < n + 1) {
                    if (!tab[isq -2]) {
                        tab[isq - 2] = true;
                        k--;
                    }
                    isq += (i + 2);
                }
            }
        }
        int[] primesN = new int[k];
        k = 0;
        for (int i = 0; i < n - 1; i++) {
            if (!tab[i]) {
                primesN[k] = i + 2;
                k++;
            }
        }
        return primesN;
    }

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

    public static int primesCount(int n) {
        boolean[] tab = new boolean[n-1];   //0 -> number 2, 1 -> number 3, ... n-2 -> number n
        int k = n - 1;  //first numbers count
        for (int i = 0; i < Math.sqrt(n) - 1; i++) {
            if (!tab[i]) {
                int isq = (i + 2) * (i + 3) - (i + 2);
                while (isq < n + 1) {
                    if (!tab[isq -2]) {
                        tab[isq - 2] = true;
                        k--;
                    }
                    isq += (i + 2);
                }
            }
        }
        return k;
    }

    public static int solNumber(int N) {
        int sol = 0;
        for (int i = 0; i < N / 4 + 1; i++) {
            sol += newton(N - 3 * i, i);
        }
        return sol;
    }

/*Red John has committed another murder. But this time, he doesn't leave
a red smiley behind. What he leaves behind is a puzzle for Patrick Jane
to solve. He also texts Teresa Lisbon that if Patrick is successful, he
will turn himself in. The puzzle begins as follows.

There is a wall of size 4xN in the victim's house. The victim also has an
infinite supply of bricks of size 4x1 and 1x4 in her house. There is a
hidden safe which can only be opened by a particular configuration of bricks
in the wall. In every configuration, the wall has to be completely covered
using the bricks. There is a phone number written on a note in the safe
which is of utmost importance in the murder case. Gale Bertram wants to
know the total number of ways in which the bricks can be arranged on the
wall so that a new configuration arises every time. He calls it M. Since
Red John is back after a long time, he has also gained a masters degree
in Mathematics from a reputed university. So, he wants Patrick to calculate
the number of prime numbers (say P) up to M (i.e. <= M). If Patrick
calculates P, Teresa should call Red John on the phone number from the
safe and he will surrender if Patrick tells him the correct answer.
Otherwise, Teresa will get another murder call after a week.

You are required to help Patrick correctly solve the puzzle.

 */

    public static void main(String[] args) {
        /*int n = 20;
        for (int i = 0; i < n + 1; i++) {
            System.out.print(newton(n, i) + "  ");
        }*/

        //System.out.println(Arrays.toString(primes(4)));
        for (int i = 1; i < 41; i++) {
            int solN = solNumber(i);
            System.out.println(i + " " + solN+ " " + primesCount(solN));
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(primesCount(solNumber(sc.nextInt())));
        }

        /*for (int i = 2; i < 1000; i++) {
            System.out.println(i + " " + primesCount(i)); // + " " + Arrays.toString(primes(i)));
            //System.out.println(i + " " + primesCount(i) + " " + Arrays.toString(primes(i)));
        }*/
    }
}
