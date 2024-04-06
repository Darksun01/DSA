package Arrays.BinarySearch;

import java.util.Scanner;

// find first and last index of an item. ex-> 10,20,20,20,30, first = 1, last = 3 for ele = 20
public class findFirstAndLastIdx {

    public static void getFirstAndLastIdx(int[] arr, int ele) {
        int low = 0, high = arr.length - 1;

        @SuppressWarnings("unused")
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ele < arr[mid]) {
                high = mid - 1;
            } else if (ele > arr[mid]) {
                low = mid + 1;
            } else {
                first = mid;
                high = mid - 1;
            }
        }

        low = 0;
        high = arr.length - 1;

        @SuppressWarnings("unused")
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ele < arr[mid]) {
                high = mid - 1;
            } else if (ele > arr[mid]) {
                low = mid + 1;
            } else {
                last = mid;
                low = mid + 1;
            }
        }

        System.out.println("FIRST: " + first + " LAST: " + last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ele = sc.nextInt();

        getFirstAndLastIdx(arr, ele);
        sc.close();
    }
}
