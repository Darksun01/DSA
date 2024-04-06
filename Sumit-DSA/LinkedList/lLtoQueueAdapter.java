package LinkedList;

/**
 * lLtoQueueAdapter
 */
import java.util.*;

public class lLtoQueueAdapter {

    public static class CustomQueueAdapter {
        LinkedList<Integer> list = new LinkedList<>();

        int size() {
            return list.size();
        }

        void add(int item) {
            list.addLast(item);
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            return list.removeFirst();
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            return list.getFirst();
        }
    }

    public static void main(String[] args) {
        CustomQueueAdapter customQueueAdapter = new CustomQueueAdapter();
        customQueueAdapter.add(10);
        customQueueAdapter.add(20);
        customQueueAdapter.add(30);
        customQueueAdapter.add(40);
        System.out.println("Remove: " + customQueueAdapter.remove());
    }
}
