package GenericTree;

/**
 * removeLeavesFronGenericTree
 */
import java.util.*;

public class removeLeavesFromGenericTree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    static void removeLeaves(Node node) {
        // we are iterating reverse beacause if you iterate from 0 to n, you will skip
        // some ele.
        // suppose you have to remove even no. from arraylist = [2,4,5,6,9]
        // once you remove 0th index, rest of the array list towars left so now
        // arraylist is [4,5,6,9]
        // since you have already moved for 0 index your i will be at 1, but array list
        // has shifted so you will directly check for ele 5, therefore skipping ele 4
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.isEmpty()) {
                node.children.remove(child);// if node's child does not habe children we remove that child.
            }
            // this operation cannot be done in postorder as then it will remove some of the
            // non leaf nodes as well.
            // for better understanding dry run on given tree.
        }

        for (Node child : node.children) {
            removeLeaves(child);
        }
    }

    static void displayTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        for (Node child : node.children) {
            displayTree(child);
        }
    }

    static void displayTreeLineWise(Node node) {// Level Order
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
        displayTreeLineWise(root);
        removeLeaves(root);
        System.out.println();
        displayTreeLineWise(root);
    }
}