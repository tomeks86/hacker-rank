import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        int[][] table = new int[][] {
                {1, 0},
                {3, 1},
                {4, 2},
                {2, 3},
                {6, 4}
        };

        int[] scores = new int[] {1, 3, 4, 2, 6, -1};
        int[][] tab2 = new int[scores.length][2];

        for (int i = 0; i < scores.length; i++) {
            tab2[i][0] = scores[i];
            tab2[i][1] = i;
        }

        /*Comparator<Integer> descending = (i1, i2) -> {
            return i2.compareTo(i1);
        };*/

        class Hotel {
            int score;
            int id;
            String name;

            public Hotel(int score, int id, String name) {
                this.score = score;
                this.id = id;
                this.name = name;
            }
        }

        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(3, 323, "rembert"));
        hotels.add(new Hotel(4, 322, "balat"));
        hotels.add(new Hotel(1, 345, "rabar"));
        hotels.add(new Hotel(1, 346, "franks"));
        hotels.add(new Hotel(6, 215, "barbar"));

        Comparator<Hotel> descending = (h1, h2) -> {
            if (h2.score > h1.score) return 1;
            else if (h1.score > h2.score) return -1;
            else return Integer.compare(h1.id, h2.id);
        };

        //Collections.sort(hotels, descending);
        hotels.stream()
                .sorted(descending)
                .forEach(h -> System.out.println(h.name + " " + h.id + " " + h.score));
        System.out.println();
        hotels.forEach(h -> System.out.println(h.name + " " + h.id + " " + h.score));

        System.out.println();
        Arrays.asList(tab2)
                .stream()
                .sorted((int[] t1, int[] t2) -> t2[1] - t1[1])
                .forEach((int[] t) -> System.out.println(t[0] + " " + t[1]));

        System.out.println();
        int[][] tab3 = tab2.clone();
        Arrays.sort(tab3, (t1, t2) -> t2[1] - t1[1]);
        Arrays.asList(tab3).forEach(t -> System.out.println(t[0]+ " " + t[1]));

        System.out.println();
        int[] max = Arrays.asList(tab2)
                .stream()
                .reduce((i1, i2) -> (i1[1] > i2[1]) ? i1 : i2)
                .get();
        System.out.println(Arrays.toString(max));
    }
}
