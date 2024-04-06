package Arrays;

/**
 * inverseOFArray
 */
// values will always lie b/w 0 to n-1(both inclusive). No duplicate values
// ex -> 4 3 0 1 2 -> 2 3 4 1 0 => we iterchange index and their values, for
// ex-> on 0 idx value 4 was there so in inverse arr on 4 idx value 0 will be
// there
import java.util.*;

public class inverseOFArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        arrInverse(arr);
        sc.close();
    }

    private static void arrInverse(int[] arr) {
        int[] inverse = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            inverse[arr[i]] = i;
        }
        printArr(inverse);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}