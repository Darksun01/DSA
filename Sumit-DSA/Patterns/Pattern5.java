
/**
 * Pattern5
 */
import java.util.*;

public class Pattern5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPattern5(n);
        sc.close();
    }

    private static void printPattern5(int n) {
        int space = n / 2;
        int star = 1;
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= space; k++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= star; j++) {
                System.out.print("* ");
            }
            System.out.println();
            if (i >= n / 2) {
                space = space + 1;
                star = star - 2;
            } else {
                space = space - 1;
                star = star + 2;
            }
        }
    }
}