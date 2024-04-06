package Arrays;

/**
 * sumOf2Arrays
 */
import java.util.*;

public class sumOf2Arrays {

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
        getSumOf2Arrays(arr1, arr2);
        sc.close();
    }

    private static void getSumOf2Arrays(int[] arr1, int[] arr2) {
        int carry = 0;
        int len1 = arr1.length, len2 = arr2.length;
        int length = len1 > len2 ? len1 : len2;
        int[] result = new int[length];
        while (len1 > 0 || len2 > 0) {
            int ele1 = len1 > 0 ? arr1[len1 - 1] : 0;
            int ele2 = len2 > 0 ? arr2[len2 - 1] : 0;
            int ele = ele1 + ele2 + carry;
            carry = ele / 10;
            ele = ele % 10;
            result[length - 1] = ele;
            len1--;
            len2--;
            length--;
        }
        if (carry > 0) {
            System.out.print(carry);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}