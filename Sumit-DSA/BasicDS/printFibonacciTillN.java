
/**
 * printFibonacciTillN
 */

import java.util.*;

public class printFibonacciTillN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        printAllPrimeNumberTillN(n);
        sc.close();
    }

    private static void printAllPrimeNumberTillN(int n) {
        // The logic is to print the inital number in this case a, then move the
        // pointers one place forward. Ex->
        // initially -> a=0,b=1,c=0
        // 1st iteration -> a gets printed, so our series at this point is 0. now
        // c=a+b(c=1), a=b,b=c
        // 2nd iteration -> a=1, b=1 c=? a gets printed, so our series at this point is
        // 0,1. now c=a+b(c=2), a=b,b=c
        // 3rd iteartion -> a=1, b=2, c=? a gets printed, so our series at this point is
        // 0,1,1. now c=a+b(c=5), a=b,b=c

        System.out.println("Printing Fibonacci Numbers");
        int a = 0, b = 1, c = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }
}