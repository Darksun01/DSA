package FunctionsAndNumberSystem;

/**
 * anyBaseToAnyBase
 */
import java.util.*;

public class anyBaseToAnyBase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int base1 = sc.nextInt();
        int base2 = sc.nextInt();

        convertFromAnyBaseToAnyBase(num1, base1, base2);
        sc.close();
    }

    private static void convertFromAnyBaseToAnyBase(int num1, int base1, int base2) {
        int decimalNum = anyBaseToDecimal(num1, base1);
        int convertedNum = decimalToAnyBase(decimalNum, base2);
        System.out.println(convertedNum);
    }

    private static int decimalToAnyBase(int decimalNum, int base2) {
        int convertedNum = 0;
        int count = 0;
        while (decimalNum != 0) {
            int rem = decimalNum % base2;
            decimalNum = decimalNum / base2;
            count++;
            int pow = (int) Math.pow(10, count - 1);
            convertedNum += rem * pow;
        }
        return convertedNum;
    }

    private static int anyBaseToDecimal(int num, int base) {
        int convertedNum = 0;
        int count = 0;
        while (num != 0) {
            int rem = num % 10;
            num = num / 10;
            count++;
            int pow = (int) Math.pow(base, count - 1);
            convertedNum += rem * pow;
        }
        return convertedNum;
    }
}
