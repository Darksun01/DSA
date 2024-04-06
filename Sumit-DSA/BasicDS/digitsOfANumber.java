
/**
 * digitsOfANumber
 */
import java.util.*;

public class digitsOfANumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDigitsOfANumber(n);
        sc.close();
    }

    private static void printDigitsOfANumber(int n) {
        // Debug for better understanding.
        // condition is set to div!=0 and not to n!=0 in while loop reason being that if
        // the numbe ends with 0(ex->1200) the n!=0 condition will not print last two
        // zeroes.

        int digitCount = numberCount(n);
        int div = (int) Math.pow(10, digitCount - 1);
        while (div != 0) {
            int quo = n / div;
            System.out.println(quo);

            n = n % div;
            div = div / 10;
        }
    }

    private static int numberCount(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }
}
