package GenericTree;

/**
 * traversalGenericTree
 */
import java.util.*;

public class traversalGenericTree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static void printTraversals(Node node) {
        System.out.println("Node Pre " + node.data);

        for (Node child : node.children) {
            System.out.println("Edge Pre: " + node.data + "-" + child.data);
            printTraversals(child);
            System.out.println("Edge post: " + child.data + "-" + node.data);
        }
        System.out.println("Node Post " + node.data);
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
        printTraversals(root);
    }
}