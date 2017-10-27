import java.util.*;
import java.util.stream.IntStream;

public class ComparatorTest {
    static class Player{
        String name;
        int score;

        Player(String name, int score){
            this.name = name;
            this.score = score;
        }
    }

    static class Checker implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            if (o1.score != o2.score) return o2.score - o1.score;
            else return o1.name.compareTo(o2.name);
        }
    }

    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }*/

        String test = "abc dasf something wrong here";
        System.out.println(test.substring(0).indexOf("here"));

        int[] arr = {9, 9, 3, 2, 6, 3};
        /*int[] sortedIndices = IntStream.range(0, arr.length)
                .boxed().sorted((i, j) -> Integer.compare(arr[j], arr[i]))
                .mapToInt(ele -> ele).toArray();
        System.out.println(Arrays.toString(sortedIndices));*/

        /*Comparator<Integer> descending = (i1, i2) -> {
            return i2.compareTo(i1);
        };

        TreeMap<Integer, Integer> map = new TreeMap<>(descending);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }*/

        Comparator<Integer> descending = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        TreeMap<Integer, Integer> map = new TreeMap<>((i1, i2) -> {
            return i2.compareTo(i1);
        });

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        System.out.println(map.toString());
    }
}
