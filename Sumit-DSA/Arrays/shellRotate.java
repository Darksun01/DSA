package Arrays;

import java.util.Scanner;

/**
 * shellRotate
 */
// take a 1d array & fill the ele of shell in that arr.
// rotate that arr by k times
// now refill the shell by that rotated 1d arr
public class shellRotate {

    static void rotateShell(int[][] arr, int row, int col, int shell, int k) {
        int[] oneDArr = fillOneDArray(arr, row, col, shell);
        rotateArr(oneDArr, k);
        fillTwoDArray(oneDArr, arr, row, col, shell);
    }

    private static int[] fillOneDArray(int[][] arr, int row, int col, int shell) {
        int minCol = shell - 1, minRow = shell - 1;
        int maxCol = arr.length - shell, maxRow = arr.length - shell;

        int size = 2 * (maxRow - minRow + maxCol - minCol);// derived from (2 * (maxCol - minCol + 1) + 2 * (maxRow -
                                                           // minRow + 1))-4, -4 so that corners do not get counter
                                                           // twice
        int[] oneD = new int[size];

        int idx = 0;
        for (int i = minRow, j = minCol; i <= maxRow; i++) {
            oneD[idx] = arr[i][j];
            idx++;
        }
        minCol++;

        for (int i = maxRow, j = minCol; j <= maxCol; j++) {
            oneD[idx] = arr[i][j];
            idx++;
        }
        maxRow--;

        for (int i = maxRow, j = maxCol; i >= minRow; i--) {
            oneD[idx] = arr[i][j];
            idx++;
        }
        maxCol--;

        for (int i = minRow, j = maxCol; j >= minCol; j--) {
            oneD[idx] = arr[i][j];
            idx++;
        }
        minRow++;

        return oneD;
    }

    static void rotateArr(int[] oneDArr, int k) {
        k = k % oneDArr.length;
        if (k < 0) {
            k = k + oneDArr.length;
        }

        reverse(oneDArr, 0, oneDArr.length - k - 1);
        reverse(oneDArr, oneDArr.length - k, oneDArr.length - 1);
        reverse(oneDArr, 0, oneDArr.length - 1);
    }

    private static void reverse(int[] arr, int li, int ri) {
        while (li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            li++;
            ri--;
        }
    }

    static void fillTwoDArray(int[] oneD, int[][] arr, int row, int col, int shell) {
        int minCol = shell - 1, minRow = shell - 1;
        int maxCol = arr.length - shell, maxRow = arr.length - shell;

        int idx = 0;
        for (int i = minRow, j = minCol; i <= maxRow; i++) {
            arr[i][j] = oneD[idx];
            idx++;
        }
        minCol++;

        for (int i = maxRow, j = minCol; j <= maxCol; j++) {
            arr[i][j] = oneD[idx];
            idx++;
        }
        maxRow--;

        for (int i = maxRow, j = maxCol; i >= minRow; i--) {
            arr[i][j] = oneD[idx];
            idx++;
        }
        maxCol--;

        for (int i = minRow, j = maxCol; j >= minCol; j--) {
            arr[i][j] = oneD[idx];
            idx++;
        }
        minRow++;
    }

    static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int shell = sc.nextInt();// which shell to rotate
        int k = sc.nextInt(); // how many times to rotate
        rotateShell(arr, row, col, shell, k);
        display(arr);
        sc.close();
    }

}