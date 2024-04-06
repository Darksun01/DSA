package Arrays;

/**
 * exitMatrix
 */
// tell at which point we exit matrix. Everytime we encounter 1 we take 90
// degree turn
public class exitMatrix {

    static void getExitPoint(int[][] arr, int row, int col) {
        int i = 0, j = 0;
        int dir = 0;// direction. 0->east, 1->south, 2->west, 3->north
        while (true) {
            dir = (dir + arr[i][j]) % 4;
            if (dir == 0) {// east
                j++;
            } else if (dir == 1) {// south
                i++;
            } else if (dir == 2) {// west
                j--;
            } else if (dir == 3) {// north
                i--;
            }

            if (i < 0) {
                i++;
                break;
            } else if (i >= arr.length) {
                i--;
                break;
            } else if (j < 0) {
                j++;
                break;
            } else if (j >= arr[0].length) {
                j--;
                break;
            }
        }
        System.out.println("Exit Point: " + i + " " + j);
    }

    public static void main(String[] args) {
        int row = 4, col = 4;
        int[][] arr = { { 0, 0, 1, 0 },
                { 1, 0, 0, 1 },
                { 0, 0, 0, 1 },
                { 1, 0, 1, 0 } };
        getExitPoint(arr, row, col);
    }
}