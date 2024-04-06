package FunctionsAndNumberSystem;

/**
 * anyBaseAddition
 */
import java.util.*;

public class anyBaseAddition {
    // Alterate Method: Convert both the number to base 10. then add them normally
    // and then reconvert them to their original base.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int sum = getSum(base, num1, num2);
        System.out.println(sum);
        sc.close();
    }

    private static int getSum(int base, int num1, int num2) {
        int carry = 0;
        int power = 1;
        int sum = 0;
        while (num1 > 0 || num2 > 0 || carry > 0) {
            int d1 = num1 % 10;
            int d2 = num2 % 10;

            num1 = num1 / 10;
            num2 = num2 / 10;

            int d = d1 + d2 + carry;
            carry = d / base;
            d = d % base;

            sum += d * power;
            power *= 10;
        }
        return sum;
    }
}