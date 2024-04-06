
/**
 * printAllPrimeNumberTillN
 */
import java.util.*;

public class printAllPrimeNumberTillN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printAllPrimeNumberTillNOPTIMAL(n);
        sc.close();
    }

    private static void printAllPrimeNumberTillNOPTIMAL(int n) {
        if (n < 2) {
            System.out.println("number not valid");
        }

        for (int i = 2; i < n; i++) {
            int count = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println(i + " is a prime number");
            }
        }
    }
}