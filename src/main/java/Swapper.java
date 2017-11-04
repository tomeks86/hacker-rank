public class Swapper {
    public static int swaper(int i, int j) {
        return i;
    }

    public static void swap(int i, int j) {
        i = swaper(j, j = i);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.printf("a = %d, b = %d%n", a, b);
        a = swaper(b, b = a);
        //swap(a, b);
        System.out.printf("a = %d, b = %d%n", a, b);
    }
}
