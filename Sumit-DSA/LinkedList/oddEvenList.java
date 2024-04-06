package LinkedList;

/**
 * oddEvenList
 */

public class oddEvenList {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;
        int size;

        void display() {
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

        void addLast(int item) {
            Node newNode = new Node();
            newNode.data = item;
            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        int removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            int val = 0;
            if (size == 1) {
                val = head.data;
                head = tail = null;
            } else {
                Node temp = head;
                head = head.next;
                val = temp.data;
                temp.next = null;
            }
            size--;
            return val;
        }

        void seperateOddEven() {
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();

            while (this.size > 0) {
                int val = this.removeFirst();
                if (val % 2 == 0) {
                    even.addLast(val);
                } else {
                    odd.addLast(val);
                }
            }

            if (odd.size > 0 && even.size > 0) {
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            } else if (even.size > 0) {
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;

            } else if (odd.size > 0) {
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(2);
        list.addLast(4);
        list.addLast(1);
        list.addLast(6);
        list.addLast(7);
        list.addLast(9);
        list.addLast(11);
        list.addLast(10);
        list.addLast(13);
        list.display();
        list.seperateOddEven();
        list.display();
    }
}
