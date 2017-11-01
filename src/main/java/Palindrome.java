import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    Stack<Character> stack = new Stack<>();
    Queue<Character> queue = new LinkedList<>();

    void pushCharacter(char ch) {
        stack.push(ch);
    }

    void enqueueCharacter(char ch) {
        queue.add(ch);
    }

    char popCharacter() {
        return stack.pop();
    }

    char dequeueCharacter() {
        return queue.poll();
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();

        String word = "abcdcba";
        int length = word.length();
        for (char ch : word.toCharArray()) {
            p.pushCharacter(ch);
            p.enqueueCharacter(ch);
        }

        boolean isPalindrome = true;

        for (int i = 0; i < length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);
    }
}
