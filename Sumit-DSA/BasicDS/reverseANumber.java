
/**
 * reverseANumber
 */
import java.util.*;

public class reverseANumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        numberReverse(n);
        sc.close();
    }

    private static void numberReverse(int n) {

        while (n > 0) {
            int rem = n % 10;
            System.out.println(rem);
            n = n / 10;
        }
    }
}
