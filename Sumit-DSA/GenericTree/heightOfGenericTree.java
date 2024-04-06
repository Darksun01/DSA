package GenericTree;

/**
 * heightOfGenericTree
 */
import java.util.*;

public class heightOfGenericTree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static int findHeight(Node node) {
        if (node == null) {// when tree arr is null
            return -1;
        }
        int height = 0;
        if (node.children.isEmpty()) {
            return 0;
        }

        for (Node child : node.children) {
            int childHeight = findHeight(child);
            if (childHeight > height) {
                height = childHeight;
            }
        }

        return height + 1;
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
        System.out.println(findHeight(root));
    }
}
