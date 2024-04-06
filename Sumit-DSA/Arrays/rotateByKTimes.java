package Arrays;

/**
 * rotateByKTimes
 */
import java.util.*;

public class rotateByKTimes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        rotateAnArray(arr, k);
        sc.close();
    }

    private static void rotateAnArray(int[] arr, int k) {
        k = k % arr.length;
        if (k < 0) {
            k = k + arr.length;// if k = -1, then -1 + 6(assumed arr len) = 5, therefore you have to roatate
                               // arr 5 times
        }
        reverseArr(arr, 0, arr.length - k - 1);// reversing the first part. only 0 to n-k
        reverseArr(arr, arr.length - k, arr.length - 1);// reversing the second part, n-k to n
        reverseArr(arr, 0, arr.length - 1);// reversing the whole arr, after both have reversed we reverse the whole arr
                                           // to get the req. result
        printArr(arr);
    }

    private static void reverseArr(int[] arr, int i, int j) {
        int left = i, right = j;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
