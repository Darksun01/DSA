package Stacks;

/**
 * balancedBrackets
 */
import java.util.*;

public class balancedBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        boolean result = areBracketsBalanced(exp);
        System.out.println(result);
        sc.close();
    }

    private static boolean areBracketsBalanced(String exp) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() <= 0 || st.peek() != '(') {
                    return false;
                } else {
                    st.pop();
                }
            } else if (ch == ']') {
                if (st.size() <= 0 || st.peek() != '[') {
                    return false;
                } else {
                    st.pop();
                }
            } else if (ch == '}') {
                if (st.size() <= 0 || st.peek() != '{') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        if (st.isEmpty())
            return true;
        return false;
    }
}
