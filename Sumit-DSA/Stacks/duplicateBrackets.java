package Stacks;

/**
 * duplicateBrackets
 */
import java.util.*;

public class duplicateBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean isDuplicate = checkForDuplicateBrackets(str);
        System.out.println(isDuplicate);
        sc.close();
    }

    private static boolean checkForDuplicateBrackets(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                if (st.peek() == '(') {
                    return true;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }
}
// test case: ((a+b)+(a+b)) -> no duplicate brackets therefore false
// test case: ((a+b))+(a+b) -> true since there is a duplicate brackt in the
// first expression.