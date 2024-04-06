package LinkedList;

/**
 * reverseAllUsingRecursion
 */
public class reverseDisplayRecursively {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;
        int size;

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

        void displayRecursively(Node head) {
            if (head.next == null) {
                System.out.print(head.data + "->");
                return;
            }
            displayRecursively(head.next);
            System.out.print(head.data + "->");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.displayRecursively(list.head);
    }
}