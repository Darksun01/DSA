
/**
 * inverseOfANumber
 */
import java.util.*;

public class inverseOfANumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        numberInverse(n);
        sc.close();
    }

    private static void numberInverse(int n) {
        int inversedNum = 0;
        int idx = 0;
        while (n > 0) {
            int rem = n % 10;
            idx++;
            inversedNum += Math.pow(10, rem - 1) * idx;
            n = n / 10;
        }
        System.out.println(inversedNum);
    }
}