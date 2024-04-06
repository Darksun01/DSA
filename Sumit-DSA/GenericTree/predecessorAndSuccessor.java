package GenericTree;

/**
 * predecessorAndSuccessor
 */
import java.util.*;

public class predecessorAndSuccessor {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // a predecessor & successor is defined as ele that comes before and after a
    // given node in a preorder traversal.
    static Node predecessor = null;
    static Node successor = null;

    static int state = 0; // variable to track pre and suc

    static void findPredecessorAndSuccessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state = 1;// once we have found the given node , we increase the state to 1, in else cond.
                          // we can see that successor node will be
            } else {
                predecessor = node;// if state is 0 that means we have not yet found predecessor and should keep
                                   // going.
            }
        } else if (state == 1) {
            successor = node;// last node with state 1 will be the node next to given node.
            state = 2;
        }

        for (Node child : node.children) {
            findPredecessorAndSuccessor(child, data);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node newNode = new Node();
                newNode.data = arr[i];
                if (!st.isEmpty()) {
                    st.peek().children.add(newNode);
                    st.push(newNode);
                } else {
                    root = newNode;
                    st.push(newNode);
                }
            }
        }
        findPredecessorAndSuccessor(root, 90);
        System.out.println("Prev: " + predecessor.data + " Next: " + successor.data);
    }
}
