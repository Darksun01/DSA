package Stacks;

/**
 * mergeOverlappingIntervals
 */
import java.util.*;

public class mergeOverlappingIntervals {

    // create a pair class.Implement Comparable
    // sort the pairs array.
    // now loop over pairs array.
    // if pair[i].st > st.peek().et = this means that the interval is not mergeable
    // ex-> 1-12,13-14.
    // else update the st.peek().et = max(st.peek().et, pair[i].et). need to take
    // max for pairs like 3-20, 15-19
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        printMergedIntervals(n, arr);
        sc.close();
    }

    private static void printMergedIntervals(int n, int[][] arr) {
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i].st > st.peek().et) {
                st.push(pairs[i]);
            } else {
                st.peek().et = Math.max(st.peek().et, pairs[i].et);
            }
        }

        Stack<Pair> res = new Stack<>();
        while (!st.isEmpty()) {
            res.push(st.pop());
        }
        System.out.println();
        while (!res.isEmpty()) {
            Pair newPair = res.pop();
            System.out.println(newPair.st + " " + newPair.et);
        }
    }

    public static class Pair implements Comparable<Pair> {
        int st; // starting time
        int et; // ending time

        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        // this > other return +ve
        // this = other return 0
        // this < other return -ve
        public int compareTo(Pair pair) {
            if (this.st != pair.st) {
                return this.st - pair.st;
            } else {
                return this.et = pair.et;
            }
        }
    }
}