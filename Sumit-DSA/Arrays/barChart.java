package Arrays;

/**
 * barChart
 */
import java.util.*;

public class barChart {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printBarChart(arr);
        sc.close();
    }

    private static void printBarChart(int[] arr) {
        int max = getMax(arr);
        while (max > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= max) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
            max--;
        }
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
