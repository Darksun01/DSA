package Stacks;

/**
 * stockSpan
 */
import java.util.*;

public class stockSpan {
    // Find next greater Element to the left. If there is , then minus
    // arr[st.peek()] - arr[i]. Else span will be i+1.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findTheSpanOfStock(arr, n);
        findStockSpan(arr, n);
        sc.close();
    }

    // alternate method
    private static void findStockSpan(int[] arr, int n) {

        // loop will run from left to right
        int[] spanArr = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(0);
        spanArr[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                spanArr[i] = i + 1;
            } else {
                spanArr[i] = i - st.peek();
            }
            st.push(i);
        }

        for (int ele : spanArr) {
            System.out.print(ele + " ");
        }
    }

    private static void findTheSpanOfStock(int[] arr, int n) {
        // loop is running right to left
        int[] spanArr = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                int pos = st.pop();
                int span = pos - i;
                spanArr[pos] = span;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int pos = st.pop();
            int span = pos + 1;
            spanArr[pos] = span;
        }
        for (int ele : spanArr) {
            System.out.print(ele + " ");
        }
    }
}
