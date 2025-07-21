interface ExpressionEvaluator {
    int evaluate(String expression);
}

import java.util.*;

abstract class AbstractEvaluator implements ExpressionEvaluator {
    protected boolean isOperator(char c) {
        return "+-*/^".indexOf(c) != -1;
    }

    protected int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    protected String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfix.append(stack.pop());
                stack.pop(); // Remove '('
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                    postfix.append(stack.pop());
                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
            postfix.append(stack.pop());

        return postfix.toString();
    }
}

class PostfixEvaluator extends AbstractEvaluator {
    @Override
    public int evaluate(String expression) {
        String postfix = infixToPostfix(expression);
        Stack<Integer> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = switch (ch) {
                    case '+' -> a + b;
                    case '-' -> a - b;
                    case '*' -> a * b;
                    case '/' -> a / b;
                    case '^' -> (int) Math.pow(a, b);
                    default -> 0;
                };
                stack.push(result);
            }
        }

        return stack.pop();
    }
}

public class ExpressionTest {
    public static void main(String[] args) {
        ExpressionEvaluator evaluator = new PostfixEvaluator();
        String expr = "3+(2*2)";
        int result = evaluator.evaluate(expr);
        System.out.println("Evaluated Result: " + result);
    }
}
