package GenericTree;

/**
 * areTreesMirrorInShape
 */
//we are only concerned with shape and not data.
import java.util.*;

public class areTreesMirrorInShape {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    // we are only concerned with shape and not the data.
    static boolean areTreeMirror(Node node1, Node node2) {
        if (node1.children.size() != node2.children.size()) {
            return false;
        }

        for (int i = 0; i < node1.children.size(); i++) {
            int j = node2.children.size() - 1 - i;
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(j);// to check for mirror we are going for last child for root2 node first

            boolean areMirror = areTreeMirror(child1, child2);
            if (!areMirror) {
                return false;
            }
        }
        return true;
    }

    static void levelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        queue.add(new Node(-1));
        while (!queue.isEmpty()) {
            Node removed = queue.poll();
            if (removed.data != -1) {
                System.out.print(removed.data + " ");
                for (Node child : removed.children) {
                    queue.add(child);
                }
            } else {
                if (!queue.isEmpty()) {
                    System.out.println();
                    queue.add(new Node(-1));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };

        int[] arr2 = { 10, 40, 100, -1, -1, 30, 90, -1, 80, 120, -1, 110, -1, -1, 70, -1, -1, 20, 60, -1, 50, -1, 23,
                -1, -1,
                -1 };

        Node root1 = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == -1) {
                st.pop();
            } else {
                Node newNode = new Node();
                newNode.data = arr1[i];
                if (!st.isEmpty()) {
                    st.peek().children.add(newNode);
                    st.push(newNode);
                } else {
                    root1 = newNode;
                    st.push(newNode);
                }
            }
        }

        Node root2 = null;
        Stack<Node> st1 = new Stack<>();
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == -1) {
                st1.pop();
            } else {
                Node newNode = new Node();
                newNode.data = arr2[i];
                if (!st1.isEmpty()) {
                    st1.peek().children.add(newNode);
                    st1.push(newNode);
                } else {
                    root2 = newNode;
                    st1.push(newNode);
                }
            }
        }
        levelOrder(root1);
        System.out.println();
        System.out.println();
        levelOrder(root2);
        System.out.println();
        System.out.println();
        System.out.println(areTreeMirror(root1, root2));
    }
}
