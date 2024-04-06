package GenericTree;

/**
 * maxNodeSubtree
 */
import java.util.*;

public class maxSumSubtree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static Node maxNode;
    private static int maxSum;

    static int getMaxSumSubTree(Node node) {
        // if (node.children.isEmpty()) {
        // return node.data;
        // }
        // adding base condition here will not return individual node's sum, therefore
        // will not be able to update maxsum, maxnode
        // for if we take leaf node 120, then if base condition is there then in line 20
        // we will return 120 and in line 27 we will catch 120 as subTreeSum, without
        // ever going to line 31 therefore never really updating the value of maxnode
        // and maxsum with 120. we would directly update maxnode and maxsum by
        // 120+(-110)+80., which will give wrong ans in some cases
        int sum = 0;
        for (Node child : node.children) {
            int subTreeSum = getMaxSumSubTree(child);
            sum = sum + subTreeSum;
        }
        sum = sum + node.data;
        if (sum > maxSum) {
            maxSum = sum;
            maxNode = node;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, -50, -1, -60, -1, -1, 30, -70, -1, 80, -110, -1, 120, -1, -1, 90, -1, -1, 40, -100, -1,
                -1,
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
        maxNode = new Node();
        maxSum = Integer.MIN_VALUE;
        getMaxSumSubTree(root);
        System.out.println(maxNode.data + " @ " + maxSum);
    }
}