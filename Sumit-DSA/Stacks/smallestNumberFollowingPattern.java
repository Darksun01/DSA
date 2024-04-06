package Stacks;

/**
 * smallestNumberFollowingPattern
 */
import java.util.*;

public class smallestNumberFollowingPattern {
    // watch the video
    // https://www.youtube.com/watch?v=GOCbsY7Arw4&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=130&ab_channel=Pepcoding.
    // can't explain in my own words effeciently
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        printPatternInNumber(exp);
        sc.close();
    }

    private static void printPatternInNumber(String exp) {
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == 'd') {
                st.push(count);
                count++;
            } else {
                st.push(count);
                while (!st.isEmpty()) {
                    System.out.print(st.pop() + " ");
                }
                count++;
            }
        }
        st.push(count);
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}
