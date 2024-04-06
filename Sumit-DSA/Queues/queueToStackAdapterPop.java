package Queues;

/**
 * queueToStackAdapterPop
 */
import java.util.*;

//Pop operation needs to be efficeint, i.e in O(1). Push can be in O(n).
public class queueToStackAdapterPop {

    public static class QueueToStack {
        Queue<Integer> mainQueue;
        Queue<Integer> helperQueue;

        QueueToStack() {
            mainQueue = new ArrayDeque<>();
            helperQueue = new ArrayDeque<>();
        }

        int size() {
            return mainQueue.size();
        }

        void display() {
            Integer[] arr = new Integer[size()];
            mainQueue.toArray(arr);
            System.out.print("display ");
            for (int i = 0; i < mainQueue.size(); i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        void add(int item) {
            while (!mainQueue.isEmpty()) {
                helperQueue.add(mainQueue.poll());
            }
            mainQueue.add(item);
            while (!helperQueue.isEmpty()) {
                mainQueue.add(helperQueue.poll());
            }
        }

        int remove() {
            if (mainQueue.size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int val = mainQueue.poll();
            return val;
        }

        int top() {
            if (mainQueue.size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int val = mainQueue.peek();
            return val;
        }
    }

    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        queueToStack.add(1);
        queueToStack.add(2);
        queueToStack.add(3);
        queueToStack.add(4);
        queueToStack.add(5);
        queueToStack.add(6);
        queueToStack.display();
        System.out.println("removed: " + queueToStack.remove());
        System.out.println("Peek: " + queueToStack.top());
        System.out.println("Size: " + queueToStack.size());
    }
}
