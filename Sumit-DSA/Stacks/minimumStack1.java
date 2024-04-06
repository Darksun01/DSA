package Stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * minimumStack1
 */
// contains a min func also which returns min data in the stack at any given
// time.
public class minimumStack1 {

    public static class minStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        minStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }

        int size() {
            return allData.size();
        }

        void push(int item) {
            allData.push(item);

            if (minData.isEmpty() || item <= minData.peek()) {
                minData.push(item);
            }
        }

        int pop() {
            if (allData.isEmpty()) {
                System.out.println("Stack UnderFlow");
                return -1;
            }
            int popped = allData.pop();
            if (popped == minData.peek()) {
                minData.pop();
            }

            return popped;
        }

        int top() {
            if (allData.isEmpty()) {
                System.out.println("Stack UnderFlow");
                return -1;
            }
            return allData.peek();
        }

        int min() {
            if (allData.size() == 0) {
                System.out.println("Stack UnderFlow");
                return -1;
            }
            return minData.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        minStack st = new minStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.min());
        st.push(0);
        System.out.println(st.min());
        sc.close();

    }
}
