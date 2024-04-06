package LinkedList;

/**
 * foldALinkedList
 */
// given a list like 1 2 3 4 5 6 7 make it like 1 7 2 6 3 5 4
public class foldALinkedList {

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

        Node left;

        void foldList() {
            left = this.head;
            foldListHelper(this.head, 0);
        }

        private void foldListHelper(Node node, int idx) {
            if (node == null) {
                return;
            }

            foldListHelper(node.next, idx + 1);
            Node temp = left;
            if (idx > size / 2) {
                left = left.next;
                temp.next = node;
                node.next = left;
            } else if (idx == size / 2) {
                tail = node;
                tail.next = null;
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
        list.addLast(6);
        list.display();
        list.foldList();
        list.display();
    }
}
