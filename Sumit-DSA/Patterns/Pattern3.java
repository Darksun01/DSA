
/**
 * Pattern3
 */
import java.util.*;

public class Pattern3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPattern3(n);
        sc.close();
    }

    private static void printPattern3(int n) {
        int space = n - 1, star = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= space; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= star; k++) {
                System.out.print("* ");
            }
            System.out.println();
            space--;
            star++;
        }
    }
}