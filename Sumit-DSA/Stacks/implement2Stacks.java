package Stacks;

/**
 * implement2Stacks
 */
import java.util.*;

public class implement2Stacks {

    public static class TwoStacks {
        int[] data;
        int tos1;
        int tos2;// top of he stack

        TwoStacks(int cap) {
            data = new int[cap];
            tos1 = -1; // start at the bottom
            tos2 = data.length; // start at the top
        }

        int size1() {
            return tos1 + 1;// since it starts from -1
        }

        int size2() {
            return data.length - tos2;// since it starts from the top and goes down.
        }

        void display1() {
            if (tos1 == -1) {
                System.out.println("Stack Underflow");
                return;
            }
            int i = tos1;
            while (i >= 0) {
                System.out.print(data[i] + " ");
                i--;
            }
            System.out.println();
        }

        void display2() {
            if (tos2 == data.length) {
                System.out.println("Stack Underflow");
                return;
            }
            int i = tos2;
            while (i < data.length) {
                System.out.print(data[i] + " ");
                i++;
            }
            System.out.println();
        }

        void push1(int item) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack Overflow");
                return;
            }
            tos1++;
            data[tos1] = item;
        }

        void push2(int item) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack Overflow");
                return;
            }
            tos2--;
            data[tos2] = item;
        }

        int pop1() {
            if (tos1 == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int val = data[tos1];
            tos1--;
            return val;
        }

        int pop2() {
            if (tos2 == data.length) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int val = data[tos2];
            tos2++;
            return val;
        }

        int top1() {
            if (tos1 == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return data[tos1];
        }

        int top2() {
            if (tos2 == data.length) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return data[tos2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();
        TwoStacks twoStacks = new TwoStacks(cap);
        twoStacks.push1(1);
        twoStacks.push1(2);
        twoStacks.push1(3);
        twoStacks.push2(4);
        twoStacks.push2(5);
        twoStacks.display1();
        twoStacks.display2();
        System.out.println("TOP1: " + twoStacks.top1());
        System.out.println("TOP2: " + twoStacks.top2());
        System.out.println("POP1: " + twoStacks.pop1());
        System.out.println("POP2: " + twoStacks.pop2());
        sc.close();
    }
}
