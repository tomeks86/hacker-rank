import java.util.function.BinaryOperator;

public class ExercisesJava8 {

    public static void main(String[] args) {

        /*MathOperation add = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };

        MathOperation subtract = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a - b;
            }
        };

        MathOperation multiply = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };

        MathOperation divide = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a / b;
            }
        };*/

        BinaryOperator<Integer> addition = (a, b) -> a + b;

        MathOperation add = (a, b) -> a + b;

        MathOperation subtract = (a, b) -> a - b;

        MathOperation multiply = (a, b) -> a + b;

        MathOperation divide = (a, b) -> a / b;

        System.out.println(addition.apply(5, 6));
        System.out.println(add.operation(5,6));
    }
}
