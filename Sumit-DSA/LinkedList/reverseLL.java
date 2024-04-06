package LinkedList;

/**
 * reverseLL
 */
public class reverseLL {

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
                return val;
            } else {
                int val = head.data;
                Node temp = head;
                head = head.next;
                temp.next = null;// you dont need to do steps written in line 56, 58. you can simply do head =
                                 // head.next;
                return val;
            }
        }

        int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid index");
                return -1;
            }
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        private Node getNodeAt(int idx) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        void reverseDataLinkedList() { // we have reversed the data of the nodes in the linked list
            int left = 0, right = size - 1;

            while (left < right) {
                Node lTemp = getNodeAt(left);
                Node rTemp = getNodeAt(right);
                int temp = lTemp.data;
                lTemp.data = rTemp.data;
                rTemp.data = temp;

                left++;
                right--;
            }
        }

        void reversePointerLinkedList() { // we have reversed the pointers of the nodes in the linked list
            Node prev = null;
            Node curr = head;

            while (curr != null) {
                Node next = curr.next; // storing current's next node
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node temp = head;
            head = tail;
            tail = temp;
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
        // System.out.println("Linked List Data Reversed: ");
        // newList.reverseDataLinkedList();
        // newList.display();
        System.out.println("Linked List Pointer Reversed: ");
        newList.reversePointerLinkedList();
        newList.display();
    }
}