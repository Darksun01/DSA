package GenericTree;

/**
 * display
 */
import java.util.*;

public class display {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static void displayTree(Node node) {
        String str = node.data + "==>";
        for (Node child : node.children) {
            str = str + child.data + " ";
        }
        System.out.println(str + ".");
        for (Node child : node.children) {
            displayTree(child);
        }
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

        displayTree(root);
    }
}