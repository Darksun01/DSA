package LinkedList;

/**
 * merge2SortedLL
 */
public class merge2SortedLL {

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
            newNode.next = null;
            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        LinkedList merge2List(LinkedList list1, LinkedList list2) {
            Node one = list1.head;
            Node two = list2.head;

            LinkedList mergedList = new LinkedList();
            while (one != null && two != null) {
                if (one.data < two.data) {
                    mergedList.addLast(one.data);
                    one = one.next;
                } else {
                    mergedList.addLast(two.data);
                    two = two.next;
                }
            }

            while (one != null) {
                mergedList.addLast(one.data);
                one = one.next;
            }

            while (two != null) {
                mergedList.addLast(two.data);
                two = two.next;
            }

            return mergedList;
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(10);
        list1.addLast(20);
        list1.addLast(30);
        list1.addLast(40);
        list1.addLast(50);

        LinkedList list2 = new LinkedList();
        list2.addLast(7);
        list2.addLast(9);
        list2.addLast(12);
        list2.addLast(35);
        list2.addLast(50);
        list2.addLast(60);

        LinkedList mergedList = list1.merge2List(list1, list2);

        mergedList.display();
    }
}
