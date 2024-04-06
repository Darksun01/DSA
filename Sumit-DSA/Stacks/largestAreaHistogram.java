package Stacks;

/**
 * largestAreaHistogram
 */
import java.util.*;

public class largestAreaHistogram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printLargestAreaHistogram(arr, n);
        sc.close();
    }

    private static void printLargestAreaHistogram(int[] arr, int n) {
        int[] lb = new int[n]; // left boundary of an element. Find next smaller element on the left.
        int[] rb = new int[n]; // right boundary of an element. Find next smaller element on the right.

        lb = nextSmallerOnTheLeft(arr, n);
        rb = nextSmallerOnTheRight(arr, n);

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int sum = rb[i] - lb[i] - 1; // calculating width.//since we are storing -1 as the extreme lb therefore -1
                                         // will balance it.
                                         // 1 - (-1) - 1 = 1.
            int area = arr[i] * sum; // height is arr[i].
            if (maxArea < area) {
                maxArea = area;
            }
        }

        System.out.println(maxArea);
    }

    private static int[] nextSmallerOnTheRight(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(n - 1);
        result[n - 1] = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            result[i] = st.size() > 0 ? st.peek() : arr.length;
            st.push(i);
        }
        return result;
    }

    private static int[] nextSmallerOnTheLeft(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(0);
        result[0] = -1;
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            result[i] = st.size() > 0 ? st.peek() : -1;
            st.push(i);
        }
        return result;
    }
}
