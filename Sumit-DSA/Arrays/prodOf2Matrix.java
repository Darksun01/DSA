package Arrays;

import java.util.Scanner;

/**
 * prodOf2Matrix
 */
public class prodOf2Matrix {

    static void getMatrixProd(int r1, int c1, int[][] arr1, int r2, int c2, int[][] arr2) {
        if (c1 != r2) {
            System.out.println("Invalid");
            return;
        }

        int[][] prod = new int[r1][c2];
        for (int i = 0; i < prod.length; i++) {
            for (int j = 0; j < prod[0].length; j++) {
                for (int k = 0; k < c1; k++) {
                    prod[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        for (int i = 0; i < prod.length; i++) {
            for (int j = 0; j < prod[0].length; j++) {
                System.out.print(prod[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int[][] arr1 = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int[][] arr2 = new int[r2][c2];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        getMatrixProd(r1, c1, arr1, r2, c2, arr2);
        sc.close();
    }

}
