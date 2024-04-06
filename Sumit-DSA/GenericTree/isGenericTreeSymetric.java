package GenericTree;

/**
 * isGenericTreeSymetric
 */
import java.util.*;

public class isGenericTreeSymetric {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static boolean findIfSymetric(Node node) {
        return findIfSymetricUtil(node, node);// we are finding if tree is mirror of itself. we pass root 2 times, so
                                              // that we are traverse from left and right simultaneously and check
                                              // if tree is mirror of itself
    }

    private static boolean findIfSymetricUtil(Node node1, Node node2) {// here node1 & node2 are same nodes
        if (node1.children.size() != node2.children.size()) {
            return false;
        }

        for (int i = 0; i < node1.children.size(); i++) {
            int j = node2.children.size() - 1 - i;
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(j);

            if (!findIfSymetricUtil(child1, child2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 130,
                -1, -1,
                -1 };

        Stack<Node> st = new Stack<>();
        Node root = null;

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
        System.out.println(findIfSymetric(root));
    }
}