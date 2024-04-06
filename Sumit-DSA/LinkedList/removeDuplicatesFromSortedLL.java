package LinkedList;

/**
 * removeDuplicatesFromLL
 */

public class removeDuplicatesFromSortedLL {

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

        void removeDuplicates() {
            LinkedList res = new LinkedList();
            while (this.size() > 0) {
                int val = this.removeFirst();
                if (res.size == 0 || res.tail.data != val) {
                    res.addLast(val);
                }
            }

            this.head = res.head;
            this.tail = res.tail;
            this.size = res.size;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        list.display();
        list.removeDuplicates();
        list.display();

    }
}
