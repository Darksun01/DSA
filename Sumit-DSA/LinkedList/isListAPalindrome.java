package LinkedList;

/**
 * isListAPalindrome
 */
public class isListAPalindrome {

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

        boolean isListPalindrome() {
            left = this.head;
            return isListPalindromeHelper(this.head, 0);
        }

        private boolean isListPalindromeHelper(Node node, int idx) {
            if (node == null) {
                return true;
            }

            boolean result = isListPalindromeHelper(node.next, idx + 1);
            if (result == false) {// if the result recieved from prev val in stack is false, then that means list
                                  // isn't a palindrome
                                  // therefore we return false without checking
                return false;
            } else if (node.data != left.data) {
                return false;
            } else {
                left = left.next;
                return true;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(2);
        list.display();
        // list.reverseListPointers();
        System.out.println(list.isListPalindrome());
        // list.display();
    }
}