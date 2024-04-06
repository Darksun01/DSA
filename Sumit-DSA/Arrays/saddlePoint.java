package Arrays;

import java.util.Scanner;

/**
 * saddlePoint = least in it's row, max in it's col
 */
public class saddlePoint {

    static void findSaddlePoint(int[][] arr, int row, int col) {
        for (int i = 0; i < arr.length; i++) {
            int lowestColIdx = 0;
            for (int j = 0; j < col; j++) {// traversing in row
                if (arr[i][j] < arr[i][lowestColIdx]) {
                    lowestColIdx = j;
                }
            }
            boolean flag = true;
            for (int k = 0; k < row; k++) {
                if (arr[k][lowestColIdx] > arr[i][lowestColIdx]) {// while traversing row if we found ele > then that
                                                                  // means our current ele is not addle point.
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(arr[i][lowestColIdx]);
                return;
            }
        }
        System.out.println("No Saddle Point");
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
        findSaddlePoint(arr, row, col);
        sc.close();
    }
}