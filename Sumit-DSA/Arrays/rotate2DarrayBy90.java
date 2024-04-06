package Arrays;

/**
 * rotate2DarrayBy90
 */
// rotate a 2 D array by 90 degree
public class rotate2DarrayBy90 {

    static void rotateBy90(int[][] arr, int row, int col) {
        // first transpose the arr. row becomes col and vic versa.
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // now reverse every row
        for (int i = 0; i < row; i++) {
            int li = 0, ri = arr[i].length - 1;
            while (li < ri) {
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;
                li++;
                ri--;
            }
        }

        display(arr, row, col);
    }

    static void display(int[][] arr, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int row = 4, col = 4;
        int[][] arr = { { 11, 12, 13, 14 },
                { 21, 22, 23, 24 },
                { 31, 32, 33, 34 },
                { 41, 42, 43, 44 } };
        rotateBy90(arr, row, col);
    }
}