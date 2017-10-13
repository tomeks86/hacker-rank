import java.util.Stack;

public class BracketBalance {
    static boolean isBalanced(String expression) {
        Stack<Character> brackets = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '{' || c == '[' || c =='(') {
                brackets.push(c);
            }
            if (c == '}') if (brackets.isEmpty() || brackets.pop() != '{') return false;
            if (c == ']') if (brackets.isEmpty() || brackets.pop() != '[') return false;
            if (c == ')') if (brackets.isEmpty() || brackets.pop() != '(') return false;
        }
        if (brackets.empty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        String s1 = "{{[[(())]]}}";
        String s2 = "{[(])}";
        System.out.println(isBalanced(s1));
        System.out.println(isBalanced(s2));
    }
}
