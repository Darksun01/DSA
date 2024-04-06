
/**
 * printZ
 */
import java.util.*;

public class isGivenNumberPrime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int i = 0;
        while (i < size) {
            int number = sc.nextInt();
            isNumberPrimeBETTER(number);
            i++;
        }
        sc.close();
    }

    private static void isNumberPrimeBRUTE(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("number is prime");
        } else {
            System.out.println("number is not prime");
        }
    }

    private static void isNumberPrimeBETTER(int number) {// logic behind this approach is to iterate till
                                                         // n^1/2(ROOT n) as root n no new unique factors can be
                                                         // found.
        int count = 0;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("number is prime");
        } else {
            System.out.println("number is not prime");
        }
    }

    private static void isNumberPrimeOPTIMAL(int number) {// logic behind this approach is similar to
                                                          // isGivenNumberPrimeBETTER
                                                          // but here we brak the loop once we find a factor that
                                                          // is not 1 and the number itself.
        int count = 0;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("number is prime");
        } else {
            System.out.println("number is not prime");
        }
    }

}