package interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

public class InterpreterLambda {
    static Map<String, IntBinaryOperator> opMap = new HashMap<>();

    static {
        opMap.put("+", (a, b) -> a + b);
        opMap.put("*", (a, b) -> a * b);
        opMap.put("-", (a, b) -> a - b);
    }

    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (var s : expression.split(" ")) {
            var op = opMap.get(s);
            if (op != null) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(op.applyAsInt(left, right));
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        var expression = "7 3 - 2 1 + *";
        System.out.println(evaluate(expression));
    }

}
