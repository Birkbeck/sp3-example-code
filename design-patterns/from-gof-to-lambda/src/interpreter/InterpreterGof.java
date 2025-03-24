package interpreter;

import java.util.Stack;

public class InterpreterGof {

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    public static Expression getOperator(String s, Expression left, Expression right) {
        return switch (s) {
            case "+" -> new Add(left, right);
            case "-" -> new Subtract(left, right);
            case "*" -> new Product(left, right);
            default -> null;
        };
    }

    public static int evaluate(String expression) {
        Stack<Expression> stack = new Stack<>();
        for (String s : expression.split(" ")) {
            if (isOperator(s)) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(getOperator(s, left, right));
            } else {
                Expression i = new Number(Integer.parseInt(s));
                stack.push(i);
            }
        }
        return stack.pop().interpret();
    }

    public static void main(String[] args) {
        String expression = "7 3 - 2 1 + *";
        System.out.println(evaluate(expression));
    }

    interface Expression {
        int interpret();
    }

    public record Add(Expression leftExpression, Expression rightExpression) implements Expression {

        @Override
        public int interpret() {
            return leftExpression.interpret() + rightExpression.interpret();
        }
    }

    public record Subtract(Expression leftExpression, Expression rightExpression) implements Expression {

        @Override
        public int interpret() {
            return leftExpression.interpret() - rightExpression.interpret();
        }
    }

    public record Product(Expression leftExpression, Expression rightExpression) implements Expression {

        @Override
        public int interpret() {
            return leftExpression.interpret() * rightExpression.interpret();
        }
    }

    public record Number(int n) implements Expression {
        @Override
        public int interpret() {
            return n;
        }
    }
}
