
/**
 * Pattern6
 */
import java.util.*;

public class Pattern6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPattern6(n);
        sc.close();
    }

    private static void printPattern6(int n) {
        int star = (n / 2) + 1;
        int space = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= star; j++) {
                System.out.print("* ");
            }
            for (int k = 1; k <= space; k++) {
                System.out.print("  ");
            }
            for (int l = 1; l <= star; l++) {
                System.out.print("* ");
            }
            if (i <= n / 2) {
                space += 2;
                star--;
            } else {
                space -= 2;
                star++;
            }
            System.out.println();
        }
    }
}