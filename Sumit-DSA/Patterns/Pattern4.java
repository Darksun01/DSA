
/**
 * Pattern4
 */
import java.util.*;

public class Pattern4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPattern4(n);
        sc.close();
    }

    private static void printPattern4(int n) {
        int space = 0;
        int star = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < space; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= star; k++) {
                System.out.print("* ");
            }
            System.out.println();
            star--;
            space++;
        }
    }
}