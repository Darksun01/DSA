package Queues;

/**
 * buildDynamicQueue
 */
import java.util.*;

public class buildDynamicQueue {

    public static class DynamicQueue {
        int[] data;
        int front;
        int size;

        DynamicQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
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
                int[] newData = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    int idx = (front + i) % data.length;
                    newData[i] = data[idx];
                }
                data = newData;
                front = 0;
                int rear = (front + size) % data.length;// data length is now changes since we have pointed data to
                                                        // newData.
                data[rear] = val;
                size++;
            } else {
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int val = data[front];
            front++;
            size--;
            return val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();// capacity
        DynamicQueue customQueue = new DynamicQueue(cap);
        customQueue.add(10);
        customQueue.add(20);
        customQueue.add(30);
        customQueue.add(40);
        customQueue.add(50);
        customQueue.display();
        customQueue.add(60);
        customQueue.display();
        System.out.println("removed: " + customQueue.remove());
        System.out.println("removed: " + customQueue.remove());
        customQueue.display();
        customQueue.add(70);
        customQueue.display();
        sc.close();
    }
}