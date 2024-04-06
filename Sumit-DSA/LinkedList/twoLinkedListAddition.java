package LinkedList;

/**
 * twoLinkedListAddition
 */
public class twoLinkedListAddition {

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

        public static LinkedList addTwoList(LinkedList l1, LinkedList l2) {
            LinkedList res = new LinkedList();
            int carry = addTwoListHelper(l1.head, l2.head, l1.size, l2.size, res);
            if (carry > 0) {
                res.addFirst(carry);
            }
            return res;
        }

        // pv = place value
        private static int addTwoListHelper(Node node1, Node node2, int pv1, int pv2, LinkedList res) {
            if (node1 == null && node2 == null) {
                return 0;
            }

            int data = 0;
            if (pv1 > pv2) {
                int oc = addTwoListHelper(node1.next, node2, pv1 - 1, pv2, res);// oc = old carry
                data = node1.data + oc;
            } else if (pv2 > pv1) {
                int oc = addTwoListHelper(node1, node2.next, pv1, pv2 - 1, res);
                data = node2.data + oc;
            } else {
                int oc = addTwoListHelper(node1.next, node2.next, pv1 - 1, pv2 - 1, res);
                data = node1.data + node2.data + oc;
            }
            int rem = data % 10;
            int nc = data / 10; // new carry
            res.addFirst(rem);
            return nc;// returning new carry
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(9);
        list1.addLast(8);
        list1.addLast(7);

        LinkedList list2 = new LinkedList();
        list2.addLast(9);
        list2.addLast(8);

        LinkedList res = new LinkedList();
        res = LinkedList.addTwoList(list1, list2);
        res.display();
    }
}
