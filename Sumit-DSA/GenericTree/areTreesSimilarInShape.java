package GenericTree;

/**
 * areTreesSimilarInShape
 */
import java.util.*;;

public class areTreesSimilarInShape {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static boolean areTreesSimilar(Node node1, Node node2) {
        if (node1.children.size() != node2.children.size()) {
            return false;
        }

        for (int i = 0; i < node1.children.size(); i++) {
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(i);
            boolean areSimilar = areTreesSimilar(child1, child2);
            if (!areSimilar) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root1 = null;
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
                    root1 = newNode;
                    st.push(newNode);
                }
            }
        }

        int[] arr1 = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, -1, -1,
                -1 };
        Node root2 = null;
        Stack<Node> st1 = new Stack<>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == -1) {
                st1.pop();
            } else {
                Node newNode = new Node();
                newNode.data = arr1[i];
                if (!st1.isEmpty()) {
                    st1.peek().children.add(newNode);
                    st1.push(newNode);
                } else {
                    root2 = newNode;
                    st1.push(newNode);
                }
            }
        }
        System.out.println(areTreesSimilar(root1, root2));
    }
}