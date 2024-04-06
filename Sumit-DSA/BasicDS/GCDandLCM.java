
/**
 * GCDandLCM
 */
import java.util.*;

public class GCDandLCM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        printGcdAndLcm(n1, n2);
        sc.close();
    }

    private static void printGcdAndLcm(int n1, int n2) {
        // Gcd(Greatest Common Divisor) can be found by iterating from the samller of n1
        // and n2 till 2 and see which number divides both n1 and n2 (Brute Method).
        // Better approach would be to go with long division. search google if you
        // forgot this approach.
        int gcd = 0, lcm = 0;
        int divisor = n1;
        int dividend = n2;
        while (dividend % divisor != 0) {
            int rem = dividend % divisor;// here we have assumed that n1 is smaller than n2.
            dividend = divisor;
            divisor = rem;
        }
        gcd = divisor;

        // Lcm(Least Common Multiple) can be found using this prop: LCM * GCD = n1 * n2;
        lcm = (n1 * n2) / gcd;

        System.out.println("GCD " + gcd + " LCM " + lcm);
    }
}