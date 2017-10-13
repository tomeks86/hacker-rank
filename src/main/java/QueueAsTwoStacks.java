import java.util.Stack;

public class QueueAsTwoStacks {
    static class MyQueue<T> {
        Stack<T> front = new Stack<>();
        Stack<T> back = new Stack<>();

        void enqueue(T i) {
            back.push(i);
        }

        T dequeue() {
            if (!front.isEmpty()) return front.pop();
            else {
                rebalance();
                return front.isEmpty() ? null : front.pop();
            }
        }

        void rebalance() {
            while (!back.isEmpty()) front.push(back.pop());
        }

        T peek() {
            if (!front.isEmpty()) return front.peek();
            else {
                rebalance();
                return front.isEmpty() ? null : front.peek();
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(12);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
