package Stacks;

/**
 * minimumStack2
 */
import java.util.*;

public class minimumStack2 {

    public static class minStack {
        Stack<Integer> allData;
        int min;

        minStack() {
            allData = new Stack<>();
            min = 0;
        }

        int size() {
            return allData.size();
        }

        void push(int item) {
            if (allData.isEmpty()) {
                allData.push(item);
                min = item;
            } else if (item >= min) {
                allData.push(item);
            } else if (item < min) {
                allData.push(item + item - min); // storing a false no., it will help in identifying min during pop.
                min = item;// storing original item in min
            }
        }

        int pop() {
            int res = 0;
            if (allData.isEmpty()) {
                System.out.println("Stack UnderFlow");
                return -1;
            } else if (allData.peek() >= min) {
                res = allData.pop();
            } else if (allData.peek() < min) {
                res = min;// original value was stored in min and fake value was stored in stack
                min = 2 * min - allData.pop();// this will help our min to get back to prev min no.
            }
            return res;
        }

        int top() {
            int res = 0;
            if (allData.isEmpty()) {
                System.out.println("Stack UnderFlow");
                return -1;
            } else if (allData.peek() >= min) {
                res = allData.peek();
            } else if (allData.peek() < min) {
                res = min;
            }
            return res;
        }

        int min() {
            if (allData.size() == 0) {
                System.out.println("Stack UnderFlow");
                return -1;
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        minStack st = new minStack();
        st.push(8);
        st.push(47);
        st.push(17);
        st.push(7);
        st.push(30);
        st.push(2);
        System.out.println("fake value stored in allData " + st.allData.peek() + " top: " + st.top());
        System.out.println("min: " + st.min());
        System.out.println("popped: " + st.pop());
        System.out.println("min: " + st.min());
        sc.close();

    }
}
