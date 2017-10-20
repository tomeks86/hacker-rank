import java.util.*;
import java.util.stream.Collectors;

public class DavisStaircase {
    public HashMap<int[], Double> ijkMemo = new HashMap<>();

    public DavisStaircase() {
        this.ijkMemo = new HashMap<>();
        /*int[] ijk = {0, 0, 0};
        ijkMemo.put(ijk, 0.);*/
    }

    public double calcIJK(int i, int j, int k) {
        int[] ijk = {i, j, k};
        Arrays.sort(ijk);
        //System.out.println(Arrays.toString(ijk));
        if (ijkMemo.containsKey(ijk)) return ijkMemo.get(ijk);
        else {
            if (i > 0) {
                double ret = (double) (i + j + k) / i * calcIJK(i - 1, j, k);
                ijkMemo.put(ijk, ret);
                return ijkMemo.get(ijk); //(i + j + k) / i * calcIJK(i - 1, j, k);
            }
            else if (j > 0) {
                double ret = (double) (i + j + k) / j * calcIJK(i, j - 1, k);
                ijkMemo.put(ijk, ret);
                return ijkMemo.get(ijk);
            }
            else if (k > 0) {
                double ret = (double) (i + j + k) / k * calcIJK(i , j, k - 1);
                ijkMemo.put(ijk, ret);
                return ijkMemo.get(ijk);
            }
            else return 1.;
        }
    }

    public static HashMap<Integer, Integer> solutions = new HashMap<>();

    public int calcPossibilitiesRec(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (n == 3) return 4;
        else if (solutions.containsKey(n)) return solutions.get(n);
        else {
            solutions.put(n, calcPossibilitiesRec(n - 1) + calcPossibilitiesRec(n - 2) + calcPossibilitiesRec(n - 3));
            return solutions.get(n);
        }
    }

    public int calcPossibilities(int stairNumber) {
        int solution = 0;
        for (int i = 0; i <= stairNumber; i++) {
            for (int j = 0; j <= stairNumber / 2; j++) {
                if (i + 2 * j <= stairNumber) {
                    for (int k = 0; k <= stairNumber / 3; k++) {
                        int n = i + 2 * j + 3 * k;
                        if (n == stairNumber) solution += (int) calcIJK(i, j, k);
                        else if (n > stairNumber) break;
                    }
                } else break;
            }
        }
        return solution;
    }

}
