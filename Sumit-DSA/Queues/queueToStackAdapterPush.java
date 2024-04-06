package Queues;

/**
 * queueToStackAdapterPush
 */
import java.util.*;

public class queueToStackAdapterPush {

    public static class QueueToStackPush {
        Queue<Integer> mainQueue;
        Queue<Integer> helperQueue;

        QueueToStackPush() {
            mainQueue = new ArrayDeque<>();
            helperQueue = new ArrayDeque<>();
        }

        int size() {
            return mainQueue.size();
        }

        void add(int item) {
            mainQueue.add(item);
        }

        int remove() {
            if (mainQueue.isEmpty()) {
                System.out.println("Queue Underflow");
                return -1;
            }
            while (mainQueue.size() > 1) {
                helperQueue.add(mainQueue.poll());
            }
            int val = mainQueue.poll();
            while (helperQueue.size() > 0) {
                mainQueue.add(helperQueue.poll());
            }
            return val;
        }

        int top() {
            if (mainQueue.isEmpty()) {
                System.out.println("Queue Underflow");
                return -1;
            }
            while (mainQueue.size() > 1) {
                helperQueue.add(mainQueue.poll());
            }
            int val = mainQueue.poll();
            helperQueue.add(val);
            while (helperQueue.size() > 0) {
                mainQueue.add(helperQueue.poll());
            }
            return val;

        }
    }

    public static void main(String[] args) {
        QueueToStackPush queueToStack = new QueueToStackPush();
        queueToStack.add(1);
        queueToStack.add(2);
        queueToStack.add(3);
        queueToStack.add(4);
        queueToStack.add(5);
        queueToStack.add(6);
        System.out.println("removed: " + queueToStack.remove());
        System.out.println("Peek: " + queueToStack.top());
        System.out.println("Size: " + queueToStack.size());
        System.out.println("removed: " + queueToStack.remove());
    }
}
