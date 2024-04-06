package GenericTree;

import java.util.*;

public class findEleInGenericTree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    static boolean getElementInTree(Node node, int ele) {
        if (node.data == ele) {
            return true;
        }

        for (Node child : node.children) {
            boolean found = getElementInTree(child, ele);
            if (found) {
                return true;
            }
        }
        return false;
    }

    static void printLevelWise(Node node) {// level order
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
        printLevelWise(root);
        System.out.println();
        System.out.println(getElementInTree(root, 500));
    }
}
