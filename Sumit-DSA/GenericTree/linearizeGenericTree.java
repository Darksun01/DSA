package GenericTree;

/**
 * linearizeGenericTree
 */
import java.util.*;

public class linearizeGenericTree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }
        // until root node has more than 1 children
        while (node.children.size() > 1) {
            Node lastChild = node.children.remove(node.children.size() - 1); // last child
            Node secondLastChild = node.children.get(node.children.size() - 1);
            Node tail = getTail(secondLastChild);// last node of second last child
            tail.children.add(lastChild);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }

    static Node linearizeEfficient(Node node) {
        if (node.children.isEmpty()) {
            return node;
        }

        Node lastNodeTail = linearizeEfficient(node.children.get(node.children.size() - 1));// going to last node and
                                                                                            // saving it as tail
        // until node has more than 1 child
        while (node.children.size() > 1) {
            Node lastNode = node.children.remove(node.children.size() - 1);
            Node secondLastNode = node.children.get(node.children.size() - 1);// we removed last node so second last
                                                                              // node is at n-1
            Node secondLastNodeTail = linearizeEfficient(secondLastNode);// second last node tail
            secondLastNodeTail.children.add(lastNode);
        }
        return lastNodeTail;
    }

    static void printLevelOrder(Node node) {
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
                if (queue.size() > 0) {
                    System.out.println();
                    queue.add(new Node(-1));
                }
            }
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
        printLevelOrder(root);
        // linearize(root);
        linearizeEfficient(root);
        System.out.println();
        printLevelOrder(root);
    }
}