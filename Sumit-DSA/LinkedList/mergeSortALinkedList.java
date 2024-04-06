package LinkedList;

/**
 * mergeSortALinkedList
 */
public class mergeSortALinkedList {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;
        int size;

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println();
        }

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

        Node midOfdLL(Node head, Node tail) {
            Node fast = head;
            Node slow = head;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        LinkedList merge2List(LinkedList list1, LinkedList list2) {
            Node temp1 = list1.head;
            Node temp2 = list2.head;

            LinkedList mergedList = new LinkedList();
            while (temp1 != null && temp2 != null) {
                if (temp1.data < temp2.data) {
                    mergedList.addLast(temp1.data);
                    temp1 = temp1.next;
                } else {
                    mergedList.addLast(temp2.data);
                    temp2 = temp2.next;
                }
            }

            while (temp1 != null) {
                mergedList.addLast(temp1.data);
                temp1 = temp1.next;
            }

            while (temp2 != null) {
                mergedList.addLast(temp2.data);
                temp2 = temp2.next;
            }

            return mergedList;
        }

        LinkedList mergeSort(Node head, Node tail) {
            if (head == tail) {
                LinkedList list = new LinkedList();
                list.addLast(head.data);
                return list;
            }

            Node mid = midOfdLL(head, tail);
            LinkedList firstHalf = mergeSort(head, mid);
            LinkedList secondHalf = mergeSort(mid.next, tail);
            LinkedList completeList = merge2List(firstHalf, secondHalf);

            return completeList;
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(10);
        list1.addLast(7);
        list1.addLast(3);
        list1.addLast(11);
        list1.addLast(18);
        list1.addLast(6);
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(9);

        LinkedList reslist = list1.mergeSort(list1.head, list1.tail);
        reslist.display();
        ;

    }
}