package Queues;

/**
 * buildNormalQueue
 */
import java.util.*;

public class buildNormalQueue {
    // we are using %(modulus) so that in arr [10,20,30,40,50] if we remove 10, 20
    // and add 50,60 the new addition takes place after 50.
    // by doing modulus our rear will not exceed data.length - 1.
    // please do dry run on operations given in main func() for better
    // understanding.
    public static class CustomQueue {
        int[] data;
        int size;
        int front; // index of front of queue from where addition takes place

        CustomQueue(int cap) {
            data = new int[cap];
            size = 0;
            front = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("Stack Overflow");
                return;
            }
            int rear = (front + size) % data.length;
            data[rear] = val;
            size++;
        }

        int remove() {
            if (size == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int val = data[front];
            front = (front + 1) % data.length;
            size--;
            return val;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();// capacity
        CustomQueue customQueue = new CustomQueue(cap);
        customQueue.add(10);
        customQueue.add(20);
        customQueue.add(30);
        customQueue.add(40);
        customQueue.add(50);
        customQueue.display();
        System.out.println("removed: " + customQueue.remove());
        System.out.println("removed: " + customQueue.remove());
        customQueue.display();
        customQueue.add(60);
        customQueue.add(70);
        customQueue.display();
        sc.close();
    }
}
