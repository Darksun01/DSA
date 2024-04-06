package FunctionsAndNumberSystem;

/**
 * anyBaseMultiplication
 */
import java.util.*;

public class anyBaseMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        printProduct(base, num1, num2);
        sc.close();
    }

    private static void printProduct(int base, int num1, int num2) {
        int sum = 0;
        int power = 1;
        while (num2 != 0) {
            int d2 = num2 % 10;
            num2 = num2 / 10;

            int singleProd = singleProduct(base, num1, d2);
            sum = getSum(base, sum, singleProd * power);
            power *= 10;
        }
        System.out.println(sum);
    }

    private static int singleProduct(int base, int num1, int d2) {
        int d = 0;
        int c = 0;
        int power = 1;
        int sum = 0;
        while (num1 != 0 || c > 0) {
            int d1 = num1 % 10;
            num1 = num1 / 10;

            d = d1 * d2 + c;
            c = d / base;
            d = d % base;

            sum = sum + d * power;
            power = power * 10;
        }
        return sum;
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