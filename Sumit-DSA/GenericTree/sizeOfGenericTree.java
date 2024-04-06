package GenericTree;

/**
 * sizeOfGenericTree
 */
import java.util.*;

public class sizeOfGenericTree {
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static int count(Node root) {
        int size = 0;
        if (root.children.isEmpty() || root.children.size() == 0) {
            return size + 1;
        }

        for (Node child : root.children) {
            size = size + count(child);
        }
        size = size + 1;
        return size;
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
        System.out.println(count(root));
    }
}