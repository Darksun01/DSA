package Stacks;

/**
 * buildDynamicStack
 */
import java.util.*;

public class buildDynamicStack {
    // everything is same we just resize the arr to twice its previous size if the
    // tos is pointing to arr.length-1 and there is an ele t0 push
    public static class CustomStack {
        int[] data;
        int tos; // top of the stack

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            return tos + 1;
        }

        void display() {
            System.out.print("display : ");
            for (int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int item) {
            if (tos == data.length - 1) {
                int[] newData = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    newData[i] = data[i];
                }
                data = newData;
                tos++;
                newData[tos] = item;
            } else {
                tos++;
                data[tos] = item;
            }
        }

        int pop() {
            if (tos == -1) {
                System.out.println("StackUnderFlow");
                return -1;
            }
            int popped = data[tos];
            tos--;
            return popped;
        }

        int top() {
            if (tos == -1) {
                System.out.println("StackUnderFlow");
                return -1;
            }
            return data[tos];
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();
        CustomStack cs = new CustomStack(cap);
        cs.push(1);
        cs.push(2);
        cs.push(3);
        cs.push(4);
        cs.push(5);
        cs.display();
        System.out.println("top " + cs.top());
        System.out.println("pop " + cs.pop());
        cs.display();
        System.out.println("pop " + cs.pop());
        cs.display();
        System.out.println("top " + cs.top());
        sc.close();
    }
}
