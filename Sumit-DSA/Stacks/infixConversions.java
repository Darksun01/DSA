package Stacks;

/**
 * infixConversions
 */
import java.util.*;

public class infixConversions {

    // infix = a+b
    // prefix = +ab
    // postfix = ab+
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infixExp = sc.nextLine();
        printPreFixAndPostFix(infixExp);
        sc.close();
    }

    private static void printPreFixAndPostFix(String infixExp) {
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < infixExp.length(); i++) {
            char ch = infixExp.charAt(i);
            if (ch == '(') {
                operators.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                pre.push(ch + "");
                post.push(ch + "");
            } else if (ch == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    Character ops = operators.pop();

                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    String preVal = ops + preV1 + preV2;
                    pre.push(preVal);

                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    String postVal = postV1 + postV2 + ops;
                    post.push(postVal);
                }
                operators.pop();// to pop '('
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())) {
                    Character ops = operators.pop();

                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    String preVal = ops + preV1 + preV2;
                    pre.push(preVal);

                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    String postVal = postV1 + postV2 + ops;
                    post.push(postVal);
                }
                operators.push(ch); // to push current operator
            }
        }

        while (operators.size() > 0) {
            Character ops = operators.pop();

            String preV2 = pre.pop();
            String preV1 = pre.pop();
            String preVal = ops + preV1 + preV2;
            pre.push(preVal);

            String postV2 = post.pop();
            String postV1 = post.pop();
            String postVal = postV1 + postV2 + ops;
            post.push(postVal);
        }

        System.out.println(pre.pop());
        System.out.println(post.pop());
    }

    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}