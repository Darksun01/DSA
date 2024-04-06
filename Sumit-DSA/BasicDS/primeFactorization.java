
/**
 * primeFactorization
 */
import java.util.*;

public class primeFactorization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        primeFactors(n);
        sc.close();
    }

    private static void primeFactors(int n) {
        // i*i<n (using isGivenNumberPrime logic i.e no unique prime no. for n exists
        // beyond n^1/2 or root n)
        // property: P*Q = N, then p amd q both cannot be greater than root n(n^1/2).
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n = n / i;
                System.out.print(i + " ");
            }
        }
        if (n != 1) {
            // ex-> n=46
            // 1st iteration: i =2, 2*2 < 23, n = 23
            // now no other number is there whose square is less than 23 and also divides
            // 23.
            System.out.println(n);
        }
    }
}