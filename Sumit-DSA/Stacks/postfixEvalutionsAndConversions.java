package Stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * postfixEvalutionsAndConversions
 */
public class postfixEvalutionsAndConversions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        postFixEvaluation(exp);
        postFixConversions(exp);
        sc.close();
    }

    private static void postFixConversions(String exp) {
        Stack<String> infixStack = new Stack<>();
        Stack<String> prefixStack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                infixStack.push(ch + "");
                prefixStack.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String infixV2 = infixStack.pop();
                String infixV1 = infixStack.pop();
                String infixVal = '(' + infixV1 + ch + infixV2 + ')';
                infixStack.push(infixVal);

                String prefixV2 = prefixStack.pop();
                String prefixV1 = prefixStack.pop();
                String prefixVal = ch + prefixV1 + prefixV2;
                prefixStack.push(prefixVal);
            }
        }

        System.out.println(infixStack.peek());
        System.out.println(prefixStack.peek());
    }

    private static void postFixEvaluation(String exp) {
        Stack<Integer> evaluate = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isDigit(ch)) {
                evaluate.push(ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                Integer v2 = evaluate.pop();
                Integer v1 = evaluate.pop();
                Integer val = process(v1, v2, ch);
                evaluate.push(val);
            }
        }

        System.out.println(evaluate.peek());
    }

    private static Integer process(Integer v1, Integer v2, char operator) {
        if (operator == '+') {
            return v1 + v2;
        } else if (operator == '-') {
            return v1 - v2;
        } else if (operator == '*') {
            return v1 * v2;
        } else if (operator == '/') {
            return v1 / v2;
        }
        return 0;
    }
}
