package Arrays;

/**
 * subtract2Arrays
 */
import java.util.*;

public class subtract2Arrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        subtractionOf2Arrays(arr1, arr2);
        sc.close();
    }

    private static void subtractionOf2Arrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr2.length];
        int carry = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = result.length - 1;
        while (k >= 0) {
            int arr1Val = i >= 0 ? arr1[i] : 0; // when arr1 is smaller than arr2 then at one point i will have a -ve
                                                // value.
            // So to save us from the arrayoutofboundexception we have this check.
            int d = 0;
            if (arr2[j] + carry >= arr1Val) {
                d = arr2[j] + carry - arr1Val;
                carry = 0;
            } else {
                d = arr2[j] + carry + 10 - arr1Val;
                carry = -1;
            }

            result[k] = d;
            i--;
            j--;
            k--;
        }
        int idx = 0;
        while (idx < result.length) {
            if (result[idx] == 0) {// to skip zeros before any number.
                idx++;
            } else {
                break;
            }
        }

        while (idx < result.length) {
            System.out.print(result[idx]);
            idx++;
        }
    }
}
