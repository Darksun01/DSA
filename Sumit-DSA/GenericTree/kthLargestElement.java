package GenericTree;

/**
 * kthLargestElement
 */
import java.util.*;

public class kthLargestElement {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static int floor;

    static int getKthLargestElement(Node node, int k) {
        int factor = Integer.MAX_VALUE;
        // intially floor for infinity will be highest ele, then for highest it will be
        // second highest, then so on until we find kth highest
        for (int i = 0; i < k; i++) {
            findFloor(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }

    private static void findFloor(Node node, int factor) {
        if (node.data < factor) {
            floor = Math.max(node.data, floor);
        }
        for (Node child : node.children) {
            findFloor(child, factor);
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
        floor = Integer.MIN_VALUE;
        int kthLargest = getKthLargestElement(root, 3);
        System.out.println(kthLargest);
    }
}
