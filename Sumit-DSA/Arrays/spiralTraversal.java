package Arrays;

/**
 * spiralTraversal
 */
import java.util.*;

public class spiralTraversal {

    public static void printSpiral(int[][] arr, int row, int col) {
        int totalCount = row * col;
        int minRow = 0, minCol = 0;
        int maxRow = arr.length - 1, maxCol = arr[0].length - 1;

        int count = 0;
        while (count < totalCount) {
            for (int i = minRow; i <= maxRow && count < totalCount; i++) {
                System.out.print(arr[i][minCol] + " ");
                count++;
            }
            minCol++;
            System.out.println();

            for (int i = minCol; i <= maxCol && count < totalCount; i++) {
                System.out.print(arr[maxRow][i] + " ");
                count++;
            }
            maxRow--;
            System.out.println();

            for (int i = maxRow; i >= minRow && count < totalCount; i--) {
                System.out.print(arr[i][maxCol] + " ");
                count++;
            }
            maxCol--;
            System.out.println();

            for (int i = maxCol; i >= minCol && count < totalCount; i--) {
                System.out.print(arr[minRow][i] + " ");
                count++;
            }
            minRow++;
            System.out.println();
        }
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
        printSpiral(arr, row, col);
        sc.close();
    }
}