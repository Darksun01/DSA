package LinkedList;

/**
 * LlToStack
 */
import java.util.*;

public class LlToStackAdapter {

    public static class CustomAdapter {
        LinkedList<Integer> list;

        CustomAdapter() {
            list = new LinkedList<Integer>();
        }

        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);// you can use add last, get last and remove last also
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return list.removeFirst();
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return list.getFirst();
        }
    }

    public static void main(String[] args) {
        CustomAdapter customAdapter = new CustomAdapter();
        customAdapter.push(10);
        customAdapter.push(20);
        customAdapter.push(30);
        customAdapter.push(40);
        System.out.println("Popped: " + customAdapter.pop());
    }
}
