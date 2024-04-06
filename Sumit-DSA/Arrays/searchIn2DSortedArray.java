package Arrays;

/**
 * searchIn2DSortedArray
 */
import java.util.*;

public class searchIn2DSortedArray {

    static int findEleInSortedArray(int[][] arr, int m, int n, int ele) {// using something like binary search
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (arr[i][j] == ele) {
                return arr[i][j];
            } else if (ele > arr[i][j]) {
                i++;// if ele > then move down as in sorted 2d arr ele val increases as we move down
            } else {
                j--;// if ele < then move left as in sorted 2d arr ele val decreases as we move left
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ele = sc.nextInt();
        int res = findEleInSortedArray(arr, row, col, ele);
        System.out.println(res);
        sc.close();
    }
}