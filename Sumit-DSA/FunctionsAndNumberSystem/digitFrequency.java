package FunctionsAndNumberSystem;

/**
 * digitFrequency
 */
import java.util.*;

public class digitFrequency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int freq = countDigit(n, d);
        System.out.println(freq);
        sc.close();
    }

    private static int countDigit(int n, int d) {
        int count = 0;
        while (n != 0) {
            int rem = n % 10;
            if (rem == d) {
                count++;
            }
            n = n / 10;
        }
        return count;
    }
}
