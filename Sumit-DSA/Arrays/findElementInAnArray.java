package Arrays;

/**
 * findElementInAnArray
 */
import java.util.*;

public class findElementInAnArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int toFind = sc.nextInt();
        int idx = findTheGivenElement(arr, toFind);
        System.out.println(idx);
        sc.close();
    }

    private static int findTheGivenElement(int[] arr, int toFind) {
        int idx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toFind) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}
