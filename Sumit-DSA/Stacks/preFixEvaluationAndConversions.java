package Stacks;

/**
 * preFixEvaluationAndConversions
 */
import java.util.*;

public class preFixEvaluationAndConversions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        evaluationAndConversion(exp);
        sc.close();
    }

    private static void evaluationAndConversion(String exp) {
        Stack<Integer> evaluate = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> postfixStack = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                evaluate.push(ch - '0');
                infixStack.push(ch + "");
                postfixStack.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                Integer v1 = evaluate.pop();
                Integer v2 = evaluate.pop();
                Integer v = process(v1, v2, ch);
                evaluate.push(v);

                String infixV1 = infixStack.pop();
                String infixV2 = infixStack.pop();
                String infixVal = "(" + infixV1 + ch + infixV2 + ")";
                infixStack.push(infixVal);

                String postfixV1 = postfixStack.pop();
                String postfixV2 = postfixStack.pop();
                String postfixVal = postfixV1 + postfixV2 + ch;
                postfixStack.push(postfixVal);
            }
        }

        System.out.println(evaluate.peek());
        System.out.println(infixStack.peek());
        System.out.println(postfixStack.peek());
    }

    private static Integer process(Integer v1, Integer v2, char ch) {
        if (ch == '+') {
            return v1 + v2;
        } else if (ch == '-') {
            return v1 - v2;
        } else if (ch == '*') {
            return v1 * v2;
        } else if (ch == '/') {
            return v1 / v2;
        }
        return 0;
    }
}
