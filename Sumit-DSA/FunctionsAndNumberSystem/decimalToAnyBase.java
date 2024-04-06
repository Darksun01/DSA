package FunctionsAndNumberSystem;

/**
 * decimalToAnyBase
 */
import java.util.*;

public class decimalToAnyBase {
    // to convert any decimal value to any given base value we need to divide it by
    // the givin base and then club the remainders from last to first.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int base = sc.nextInt();
        int convertedNum = decimalToAnyGivenBase(n, base);
        System.out.println(convertedNum);
        sc.close();
    }

    private static int decimalToAnyGivenBase(int n, int base) {
        int count = 0;
        int convertedNum = 0;
        while (n != 0) {
            int rem = n % base;
            n = n / base;
            count++;
            int pow = (int) Math.pow(10, count - 1);
            convertedNum += rem * pow;
        }
        return convertedNum;
    }
    // ex-> 634 base 10 convert it to base 8.
    // 634/8-> rem = 2, divident = 79
    // 79/8-> rem = 7, divident = 9
    // 9/8-> rem = 1, divident = 1
    // 1/8-> rem = 1, divident = 0;
    // now clubbing the remainder from last to first we get -> 1172 base 8.
}