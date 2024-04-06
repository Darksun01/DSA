package Arrays;

import java.util.*;

/**
 * diagonalTraversal
 */
public class diagonalTraversal {

    static void traverseDiagonally(int[][] arr, int row, int col) {
        int m = 0, n = 0, gap = 0;
        while (gap < col) {
            m = 0;
            n = gap;
            while (m < row && n < col) {
                System.out.print(arr[m][n] + " ");
                m++;
                n++;
            }
            System.out.println();
            gap++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        traverseDiagonally(arr, m, n);
        sc.close();
    }
}