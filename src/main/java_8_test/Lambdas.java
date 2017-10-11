import java.util.Arrays;
import java.util.StringTokenizer;

public class Lambdas {
    public static void main(String[] args) {
        String test = "this is aa   stest";
        StringTokenizer st = new StringTokenizer(test);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        System.out.println("------");
        Arrays.asList(test.split("\\s")).forEach(t -> System.out.println(t));
        System.out.println("------");
        Arrays.asList(test.split("\\s+")).forEach(t -> System.out.println(t));
        System.out.println("------");


        MyMath ob = new MyMath();
        PerformOperation op;
        op = ob.isOdd();

        System.out.println(ob.checker(op,5));
        op = ob.isPrime();
        System.out.println(ob.checker(op, 5));
        op = ob.isPalindrome();
        System.out.println(ob.checker(op, 454));

    }
}

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    PerformOperation isOdd() {
        return n -> ((n % 2) > 0);
    }

    PerformOperation isPrime() {
        return n -> {
            if (n == 1) return false;
            else for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
    }

    PerformOperation isPalindrome() {
        return n -> {
            String num = String.valueOf(n);
            for (int i = 0; i < num.length() / 2; i++) {
                if (num.charAt(i) != num.charAt(num.length() - i - 1)) return false;
            }
            return true;
        };
    }
}
