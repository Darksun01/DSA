package Stacks;

/**
 * stackToQueuePsuh
 */
import java.util.*;

public class stackToQueuePush {

    public static class StackToQueuePush {
        Stack<Integer> mainStack;
        Stack<Integer> helperStack;

        StackToQueuePush() {
            mainStack = new Stack<>();
            helperStack = new Stack<>();
        }

        int size() {
            return mainStack.size();
        }

        void push(int item) {
            mainStack.push(item);
        }

        int pop() {
            if (mainStack.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            while (!mainStack.isEmpty()) {
                helperStack.push(mainStack.pop());
            }
            int val = helperStack.pop();
            while (!helperStack.isEmpty()) {
                mainStack.push(helperStack.pop());
            }
            return val;
        }

        int top() {
            if (mainStack.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            while (!mainStack.isEmpty()) {
                helperStack.push(mainStack.pop());
            }
            int val = helperStack.peek();
            while (!helperStack.isEmpty()) {
                mainStack.push(helperStack.pop());
            }
            return val;
        }
    }

    public static void main(String[] args) {
        StackToQueuePush stackToQueuePush = new StackToQueuePush();
        stackToQueuePush.push(1);
        stackToQueuePush.push(2);
        stackToQueuePush.push(3);
        stackToQueuePush.push(4);
        stackToQueuePush.push(5);

        System.out.println("popped: " + stackToQueuePush.pop());

    }
}