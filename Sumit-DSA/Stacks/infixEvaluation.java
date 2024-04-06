package Stacks;

/**
 * infixEvaluation
 */
import java.util.*;

public class infixEvaluation {
    // Logic: if character is Operand then we push.
    // if character is '(' we push.
    // if character is ')' we pop until we find '('. Then another pop to '('.
    // if character is operator we pop all greater or equal precedence charcaters.
    //

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        printEvaluation(exp);
        sc.close();
    }

    private static void printEvaluation(String exp) {
        Stack<Integer> operands = new Stack<>(); // this includes only numbers
        Stack<Character> operators = new Stack<>(); // this includes only chars like + - etc.

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char opr = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int res = operations(v1, v2, opr);
                    operands.push(res);
                }
                operators.pop();
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0'); // to convert it to digit
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())) {
                    char opr = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int res = operations(v1, v2, opr);
                    operands.push(res);
                }
                operators.push(ch);
            }
        }

        while (operators.size() > 0) {
            char opr = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();
            int res = operations(v1, v2, opr);
            operands.push(res);
        }

        System.out.println(operands.peek());

    }

    private static int operations(int v1, int v2, char opr) {
        if (opr == '+') {
            return v1 + v2;
        } else if (opr == '-') {
            return v1 - v2;
        } else if (opr == '*') {
            return v1 * v2;
        } else if (opr == '/') {
            return v1 / v2;
        }
        return 0;
    }

    private static int precedence(char operator) {
        if (operator == '+') {
            return 1;
        } else if (operator == '-') {
            return 1;
        } else if (operator == '*') {
            return 2;
        } else if (operator == '/') {
            return 2;
        }
        return 0;
    }
}
