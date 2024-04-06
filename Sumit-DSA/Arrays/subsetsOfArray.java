package Arrays;

/**
 * subsetsOfArray
 */
import java.util.*;

public class subsetsOfArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findSubsets(arr);
        sc.close();
    }

    public static void findSubsets(int[] arr) {
        int limit = (int) Math.pow(2, arr.length);// an array contains 2^arr.length no, of subsets
        for (int i = 0; i < limit; i++) {
            String set = "";
            int temp = i;
            for (int j = arr.length - 1; j >= 0; j--) {
                int rem = temp % 2;// converting to binary form
                temp = temp / 2;
                set = rem > 0 ? arr[j] + " " + set : "_ " + set;
            }
            System.out.println(set);
        }
    }
}
