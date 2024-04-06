
/**
 * Pattern8
 */
import java.util.*;

public class Pattern8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPattern8(n);
        sc.close();
    }

    private static void printPattern8(int n) {
        // can also use for condition i + j == n + 1
        int space = n - 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= space; j++) {
                System.out.print("  ");
            }
            System.out.println("*");
            space--;
        }
    }
}