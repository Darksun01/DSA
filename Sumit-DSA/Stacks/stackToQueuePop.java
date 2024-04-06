package Stacks;

/**
 * stackToQueuePop
 */
import java.util.*;

public class stackToQueuePop {

    public static class StackToQueuePop {
        Stack<Integer> mainStack;
        Stack<Integer> helperStack;

        StackToQueuePop() {
            mainStack = new Stack<>();
            helperStack = new Stack<>();
        }

        int size() {
            return mainStack.size();
        }

        void push(int item) {
            while (!mainStack.isEmpty()) {
                helperStack.push(mainStack.pop());
            }
            mainStack.push(item);
            while (!helperStack.isEmpty()) {
                mainStack.push(helperStack.pop());
            }
        }

        int pop() {
            if (mainStack.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return mainStack.pop();
        }

        int top() {
            if (mainStack.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return mainStack.peek();
        }
    }

    public static void main(String[] args) {
        StackToQueuePop stackToQueuePop = new StackToQueuePop();
        stackToQueuePop.push(1);
        stackToQueuePop.push(2);
        stackToQueuePop.push(3);
        stackToQueuePop.push(4);
        stackToQueuePop.push(5);
        stackToQueuePop.push(6);
        System.out.println("Popped: " + stackToQueuePop.pop());
        System.out.println("Top: " + stackToQueuePop.top());
    }
}
