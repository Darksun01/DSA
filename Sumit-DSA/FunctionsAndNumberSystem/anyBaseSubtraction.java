package FunctionsAndNumberSystem;

/**
 * anyBaseSubtraction
 */
import java.util.*;

public class anyBaseSubtraction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        subtractAnyBaseNumber(base, num1, num2);
        sc.close();
    }

    private static void subtractAnyBaseNumber(int base, int num1, int num2) {
        int borrowed = 0;
        int sum = 0;
        int power = 1;
        // here we are assuming num2 to always be greater number
        while (num2 != 0) {
            int d1 = num1 % 10;
            int d2 = num2 % 10;

            num1 = num1 / 10;
            num2 = num2 / 10;

            int d = 0;
            d2 = d2 + borrowed;
            if (d2 >= d1) {
                borrowed = 0;
                d = d2 - d1;
            } else {
                borrowed = -1;
                d = (d2 + base) - d1;
            }

            sum = sum + (d * power);
            power = power * 10;
        }
        System.out.println(sum);
    }
}