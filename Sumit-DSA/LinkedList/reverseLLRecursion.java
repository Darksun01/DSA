package LinkedList;

/**
 * reverseLLRecursion
 */
public class reverseLLRecursion {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;
        int size;

        void display() {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            }
            Node temp = this.head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
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

        void reverseListPointersHelper(Node head) {
            if (head.next == null) {// head == null gives null pointer exception beacuse in line 35 we are pointing
                                    // node.next.next to node but node returned from if block was null, therefore we
                                    // return once heas.next is null
                return;
            }
            reverseListPointersHelper(head.next);
            head.next.next = head;
            head.next = null;
        }

        void reverseListPointers() {// here we are reversing the pointers of Linked list
            reverseListPointersHelper(this.head);
            Node temp = this.head;
            this.head = this.tail;
            this.tail = temp; // reversing head and tail pointers
        }

        Node prev;

        void reverseListData() {// here we are reversing the data of Linked list
            prev = head;
            reverseListDataHelper(this.head, 0);
        }

        private void reverseListDataHelper(Node node, int idx) {
            if (node == null) {
                return;
            }
            reverseListDataHelper(node.next, idx + 1);
            if (idx >= size / 2) {
                int temp = prev.data;
                prev.data = node.data;
                node.data = temp;
                prev = prev.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
        // list.reverseListPointers();
        list.reverseListData();
        list.display();
    }
}