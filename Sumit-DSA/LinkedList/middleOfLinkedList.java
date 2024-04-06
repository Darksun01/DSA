package LinkedList;

/**
 * middleOfLinkedList
 */
// take 2 nodes fast and slow, iterate till fast.next && fast.next.next != null.
// while slow moves once fast will move twice.
// after the loop is finished we return slow.data
public class middleOfLinkedList {

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
            newNode.next = null;
            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        int findMidOfList() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }

            Node fast = head;
            Node slow = head;
            // second condition is used for even size of list, in that case we have to give
            // last node sif first size i.e in 1->2->3->4, we have to return 2 as the middle
            // node
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;// fast jumps 2 nodes
                slow = slow.next;// slow jumps only 1 node.
            }

            return slow.data;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        System.out.println("MID: " + list.findMidOfList());
    }
}
