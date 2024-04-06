package FunctionsAndNumberSystem;

/**
 * anyBaseToDecimal
 */
import java.util.*;

public class anyBaseToDecimal {
    // to convert any base value to decimal value we need to divide it by
    // 10 and then club the remainders from last to first.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int base = sc.nextInt();
        int decimalNum = anyGivenBaseToDecimal(num, base);
        System.out.println(decimalNum);
        sc.close();
    }

    private static int anyGivenBaseToDecimal(int num, int base) {
        int count = 0;
        int decimalNum = 0;
        while (num != 0) {
            int rem = num % 10;
            num = num / 10;
            count++;
            int pow = (int) Math.pow(base, count - 1);
            decimalNum += rem * pow;
        }
        return decimalNum;
    }
    // ex->(1172) base 8 to decimal
    // 1172/10 -> rem = 2
    // 117/10 -> rem = 7
    // 11/10 -> rem = 1
    // 1/10 -> rem = 1
    // now here to club them from last to first we have to multiply 2 by 8^0, 7 by
    // 8^1, 1 by 8^2, 1 by 8^3 and add them.
    // 2*8^0 + 7*8^1 + 1*8^2 + 1*8^3 = 634.
}