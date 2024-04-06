package Stacks;

/**
 * celebrityProblem
 */
import java.util.*;

public class celebrityProblem {
    // celebrity: someone who knows no one but everyone knows him/her.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        findCeleb(arr, m, n);
        sc.close();
    }

    private static void findCeleb(int[][] arr, int m, int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < m; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                st.push(j);// if i knows j -> i is not a celebrity
            } else {
                st.push(i);// if i does not j -> j is not a celebrity
            }
        }

        int pot = st.pop();// potential celeb
        for (int i = 0; i < arr.length; i++) {
            if (i != pot) {
                if (arr[i][pot] == 0 || arr[pot][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }

        System.out.println(pot);
    }
}
