
/**
 * benjaminBulbs
 */
import java.util.*;

public class benjaminBulbs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printOnBulbs(n);
        sc.close();
    }

    private static void printOnBulbs(int n) {
        // In this problem you have to look for perfect squares beacause only the bulbs
        // which are on perfect squares will remain on as perfect squares have odd
        // factors(2n+1 factors) while unperfect squares has even factors(2n factors).
        for (int i = 1; i * i <= n; i++) {
            System.out.println(i * i);
        }
    }
    // note->no. of fluctuations equals no. of bulbs. Initially all the bulbs are
    // off
    // every number fluctuates its multiple
    // ex->suppose there are 6 bulbs
    // 1->on
    // 2->on,off
    // 3->on,off
    // 4->on,off,on
    // 5->on,off
    // 6->on,off,on,off
    // here only 1 and 4 are perfect squares hence only them can have odd no. off
    // fluctuations. So they remain on.
}