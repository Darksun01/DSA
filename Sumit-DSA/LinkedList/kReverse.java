package LinkedList;

/**
 * kReverse
 */
import java.util.*;

public class kReverse {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;

        int getSize() {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                temp = temp.next;
                count++;
            }
            return count;
        }

        void display() {
            int size = this.getSize();
            if (size == 0) {
                System.out.println("No nodes to display");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        void addFirst(int item) {
            Node newNode = new Node();
            newNode.data = item;

            if (this.getSize() == 0) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        void addLast(int item) {
            int size = this.getSize();
            Node newNode = new Node();
            newNode.data = item;
            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int removeFirst() {
            int size = this.getSize();
            if (size == 0) {
                System.out.println("List is Empty");
                return -1;
            }
            int val = 0;
            if (size == 1) {
                val = head.data;
                head = null;
            } else {
                val = head.data;
                Node temp = head;
                head = head.next;
                temp.next = null;
            }
            return val;
        }

        void reverseKTimes(int k) {
            int size = this.getSize();

            LinkedList prev = new LinkedList();
            prev = null;
            while (size > 0) {
                LinkedList curr = new LinkedList();
                if (size >= k) {
                    for (int i = 0; i < k; i++) {
                        int val = this.removeFirst();
                        curr.addFirst(val);
                        size--;
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        int val = this.removeFirst();
                        curr.addLast(val);
                        size--;
                    }
                }

                if (prev == null) {
                    prev = curr;
                } else {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                }
            }

            this.head = prev.head;
            this.tail = prev.tail;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.display();
        list.reverseKTimes(k);
        list.display();
        sc.close();
    }
}
