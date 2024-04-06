package LinkedList;

/**
 * findIntersectionPointOfList
 */
public class findIntersectionPointOfList {

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

        int getIntersectionPoint(LinkedList l1, LinkedList l2) {
            int delta = Math.abs(l1.size - l2.size);// diff b.w the size of the two lists.
            Node temp1 = l1.head;
            Node temp2 = l2.head;
            if (l1.size > l2.size) {
                for (int i = 0; i < delta; i++) {
                    temp1 = temp1.next;// moving the head of the larger list to make the starting point of the two list
                                       // same.
                }
            } else {
                for (int i = 0; i < delta; i++) {
                    temp2 = temp2.next;
                }
            }

            while (temp1.data != temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
                if (temp1 == null || temp2 == null) {
                    return -1;
                }
            }
            return temp1.data;
        }
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addLast(1);
        l1.addLast(9);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);

        LinkedList l2 = new LinkedList();
        l2.addLast(6);
        l2.addLast(4);
        l2.addLast(8);

        l1.tail.next = l2.head;
        l1.display();
        int intersectionPoint = l1.getIntersectionPoint(l1, l2);
        System.out.println(intersectionPoint);

    }
}
