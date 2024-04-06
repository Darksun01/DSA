package LinkedList;

/**
 * removeFirst
 */
public class removeFirst {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;
        int size;

        int size() {
            return size;
        }

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

        void addLast(int val) {
            Node newNode = new Node();
            newNode.data = val;
            newNode.next = null;
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
            } else if (size == 1) {
                int val = head.data;
                head = tail = null;
                size--;
                return val;
            } else {
                int val = head.data;
                Node temp = head;
                head = head.next;
                temp.next = null;// you dont need to do steps written in line 56, 58. you can simply do head =
                size--; // head.next;
                return val;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList newList = new LinkedList();
        newList.addLast(10);
        newList.addLast(20);
        newList.addLast(30);
        newList.addLast(40);
        System.out.println("SIZE: " + newList.size());
        newList.display();
        System.out.println("Removed: " + newList.removeFirst());
        System.out.println("Head: " + newList.head.data);
    }
}
