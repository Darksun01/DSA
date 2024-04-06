package GenericTree;

import java.util.*;

public class maxInGenericTree {
    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // static int max = 0;

    public static int findMax(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.children) {
            int childMax = findMax(child);
            if (childMax > max) {
                max = childMax;
            }
        }
        if (max < node.data) {
            max = node.data;
        }
        return max;
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
        System.out.println(findMax(root));
        // System.out.println(max);
    }
}
