package GenericTree;

/**
 * ceilAndFoor
 */
import java.util.*;

public class ceilAndFoor {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static int ceil;
    static int floor;

    static void findCeilAndFloor(Node node, int data) {
        if (node.data > data) {
            ceil = Math.min(ceil, node.data);
        }

        if (node.data < data) {
            floor = Math.max(floor, node.data);
        }

        for (Node child : node.children) {
            findCeilAndFloor(child, data);
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
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        findCeilAndFloor(root, 120);
        System.out.println("Ceil: " + ceil + " Floor: " + floor);
    }
}