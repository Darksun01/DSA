
/**
 * pythagoreanTriplets
 */
import java.util.*;

public class pythagoreanTriplets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        isItPythagoreanTriplet(a, b, c);
        sc.close();
    }

    private static void isItPythagoreanTriplet(int a, int b, int c) {
        int max = Integer.MIN_VALUE;
        if (a > max) {
            max = a;
        }
        if (b > max) {
            max = b;
        }
        if (c > max) {
            c = max;
        }

        boolean isPythagoreanTriplet = false;
        if (max == a) {
            isPythagoreanTriplet = ((b * b + c * c) == (a * a));
        } else if (max == b) {
            isPythagoreanTriplet = ((b * b + a * a) == (b * b));
        } else if (max == c) {
            isPythagoreanTriplet = ((b * b + a * a) == (c * c));
        }

        System.out.println(isPythagoreanTriplet);

    }
}