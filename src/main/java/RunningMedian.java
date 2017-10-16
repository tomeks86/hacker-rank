import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
    static class DoubleHeap {
        private Comparator<Integer> maxer = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        };

        private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //to store the values higher than median
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(maxer);    //to store the values lower than the median

        public void addNumber(Integer i) {
            if (minHeap.peek() != null && i > minHeap.peek()) minHeap.add(i);
            else maxHeap.add(i);
            rebalance();
        }

        private void rebalance() {
            if (minHeap.size() - maxHeap.size() > 1) maxHeap.add(minHeap.poll());
            else if (maxHeap.size() - minHeap.size() > 1) minHeap.add(maxHeap.poll());
        }

        public double median() {
            if (minHeap.size() == maxHeap.size()) return (double) (minHeap.peek() + maxHeap.peek()) / 2.;
            else if (minHeap.size() > maxHeap.size()) return minHeap.peek();
            else return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        DoubleHeap dh = new DoubleHeap();
        for (String s : "12 4 5 3 8 7".split("\\s+")) {
            dh.addNumber(Integer.valueOf(s));
            System.out.printf("%.1f%n", dh.median());
        }

        PriorityQueue<Integer> test = new PriorityQueue<>();
        test.add(5);
        test.add(6);
        System.out.printf("%n%n%d%n", test.peek());
    }
}
