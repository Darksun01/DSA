package GenericTree;

/**
 * mirrorAGenericTree
 */
import java.util.*;

public class mirrorAGenericTree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    static void displayTree(Node node) {
        if (node.children.isEmpty()) {
            System.out.print(node.data + " ");
            return;
        }
        System.out.print(node.data + " ");
        for (Node child : node.children) {
            displayTree(child);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

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
        mirror(root);
        System.out.println();
        displayTree(root);
        sc.close();
    }
}