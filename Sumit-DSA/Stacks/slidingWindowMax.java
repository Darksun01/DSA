package Stacks;

/**
 * slidingWindowMax
 */
import java.util.*;

public class slidingWindowMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findSlidingWindowMax(arr, n, k);
        sc.close();
    }

    private static void findSlidingWindowMax(int[] arr, int n, int k) {
        int[] nge = findNextGreaterToRight(arr, n);

        for (int i = 0; i <= arr.length - k; i++) {
            int j = i;
            while (nge[j] < i + k) {
                j = nge[j];
            }
            System.out.print(arr[j] + " ");
        }
    }

    private static int[] findNextGreaterToRight(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        st.push(arr.length - 1);// index of 1st ele.
        res[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            res[i] = st.size() > 0 ? st.peek() : arr.length;
            st.push(i);
        }
        return res;
    }
}