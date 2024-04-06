package Arrays.BinarySearch;

/**
 * ceilAndFloro
 */
import java.util.*;

public class ceilAndFloor {

    public static void getCeilAndFloor(int[] arr, int num) {
        int low = 0, high = arr.length - 1, floor = Integer.MIN_VALUE, ceil = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (num > arr[mid]) {
                low = mid + 1;
                floor = mid;
            } else if (num < arr[mid]) {
                high = mid - 1;
                ceil = mid;
            } else {
                ceil = mid;
                floor = mid;
                break;
            }
        }
        System.out.println("FLOOR: " + arr[floor] + " HIGH: " + arr[ceil]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        getCeilAndFloor(arr, num);
        sc.close();
    }
}
