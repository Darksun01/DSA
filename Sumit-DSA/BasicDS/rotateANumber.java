
/**
 * rotateANumber
 */
import java.util.*;

public class rotateANumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        numberRotate(n, k);
        sc.close();
    }

    private static void numberRotate(int n, int k) {
        String num = String.valueOf(n);
        int size = num.length();

        k = k % size;
        if (k < 0) {
            k = size + k;
        }
        int div = (int) Math.pow(10, k);
        int rem = n % div;
        int q = n / div;
        int mul = (int) Math.pow(10, size - k);
        int rotatedNum = rem * mul + q;
        System.out.println(rotatedNum);

    }
}