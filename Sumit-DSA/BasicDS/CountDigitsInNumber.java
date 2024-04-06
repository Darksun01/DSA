
/**
 * CountDigitsInNumber
 */
import java.util.*;

public class CountDigitsInNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int digit = sc.nextInt();

        int count = countDigitsInNumber(digit);
        System.out.println(count);
        sc.close();
    }

    private static int countDigitsInNumber(int digit) {
        int count = 0;
        while (digit != 0) {
            digit = digit / 10;
            count++;
        }
        return count;
    }
    // for Ex-> 98765
    // 1.) 98765 / 10 = 9876, count = 1
    // 2.) 9876 / 10 = 987, count = 2
    // 3.) 987 / 10 = 98, count = 3
    // 4.) 98 / 10 = 9, count = 4
    // 5.) 9 / 10 = 0, count = 5
}