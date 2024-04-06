package LinkedList;

/**
 * kthEleFromEnd
 */

//you cannot use size to solve this question. neither directly nor indirectly.
//also you have to give kth element from the end.
import java.util.*;

public class kthEleFromEnd {

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

        void addFirst(int val) {
            Node newNode = new Node();
            newNode.data = val;
            if (size == 0) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        void addAt(int idx, int val) {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            }

            if (idx < 0 || idx > size) {
                System.out.println("Invalid Index");
                return;
            }

            Node newNode = new Node();
            newNode.data = val;

            if (idx == 0) {
                newNode.next = head;// you can use addFirst method also
                head = newNode;
            } else if (idx == size) {
                tail.next = newNode;// you can use addLast method also
                tail = newNode;
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
            size++;
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

        int removeAtIndex(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid Index");
                return -1;
            }

            if (size == 0) {
                System.out.println("List is Empty");
                return -1;
            } else if (size == 1) {
                int val = head.data;
                head = tail = null;
                size--;
                return val;
            } else if (idx == 0) {
                Node temp = head;
                head = head.next;
                temp.next = null;
                int val = temp.data;
                size--;
                return val;
            } else if (idx == size - 1) {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                size--;
                return tail.data;
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                int val = temp.next.data;
                temp.next = temp.next.next;
                size--;
                return val;
            }
        }

        int removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (size == 1) {
                int data = head.data;
                head = tail = null;
                size--;
                return data;
            } else {
                Node temp = head;
                Node temp1 = head.next;
                while (temp1.next != null) {
                    temp = temp.next;
                    temp1 = temp1.next;
                }
                int data = temp1.data;
                temp.next = null;
                tail = temp;
                size--;
                return data;
            }
        }

        int getHead() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return head.data;
        }

        int getTail() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return tail.data;// if tail not given then iterate till next!=null and return that node data.
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

        public int getKthElement(int k) {
            Node fast = head;
            Node slow = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;// maintaining k distance between 2 nodes
            }

            while (fast != tail) {
                fast = fast.next;
                slow = slow.next;// becasue there is k distance b/w fast and slow, when fast = null, slow = k
            }

            return slow.data;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        System.out.println("Kth Element: " + list.getKthElement(k));
        sc.close();
    }
}
