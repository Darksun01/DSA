package GenericTree;

/**
 * findDiameterOfGenericTree
 */
// highest no. edges between any 2 nodes in a generic tree is known as its diameter.
import java.util.*;

public class findDiameterOfGenericTree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static int diameter;

    static int findDiameter(Node node) {// we are only finding height of tree with and extra height of second deepest
                                        // node,
        int dc = -1;// deepest child
        int sdc = -1;// second deepest child

        for (Node child : node.children) {
            int ch = findDiameter(child);// child height
            if (ch > dc) {
                sdc = dc;
                dc = ch;
            } else if (ch > sdc) {
                sdc = ch;// if child height is only greater than second deepest child
            }
        }

        // potential diameter
        int potDia = sdc + dc + 2;// extra 2 for extra edges of parent node.
        if (potDia > diameter) {
            diameter = potDia;
        }
        return dc + 1; // returning dc + 1, because node will add its own edge also
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                stack.pop();
            } else {
                Node newNode = new Node();
                newNode.data = arr[i];
                if (!stack.isEmpty()) {
                    stack.peek().children.add(newNode);
                    stack.push(newNode);
                } else {
                    root = newNode;
                    stack.push(newNode);
                }
            }
        }
        diameter = 0;
        findDiameter(root);
        System.out.println("Diameter: " + diameter);
    }
}
