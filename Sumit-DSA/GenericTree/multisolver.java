package GenericTree;

/**
 * multisolver
 */
import java.util.*;

public class multisolver {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static int size;
    static int min;
    static int max;
    static int height;

    static void solveForMultipleAttributes(Node node, int depth) {
        size = size + 1;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);

        for (Node child : node.children) {
            solveForMultipleAttributes(child, depth + 1);
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
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;
        solveForMultipleAttributes(root, 0);
        System.out.println("Size: " + size + " Min: " + min + " Max: " + max + " Height: " + height);
    }
}