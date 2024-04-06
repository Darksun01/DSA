package LinkedList;

/**
 * AddLastInLL
 */
public class AddLastInLL {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;
        int size;

        void addLast(int val) {
            Node newNode = new Node();
            newNode.data = val;

            if (size == 0) {
                newNode.next = null;
                head = tail = newNode;
            } else {
                newNode.data = val;
                tail.next = newNode;// current tail pointing to newNode = head->tail->newNode
                tail = newNode;// now tail is newNode = head->node->tail
                tail.next = null;// tail.next i.e newNode.next is null = head->node->tail->null
            }
            size++;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        System.out.println("Head " + linkedList.head.data);
        System.out.println("Tail " + linkedList.tail.data);
    }
}