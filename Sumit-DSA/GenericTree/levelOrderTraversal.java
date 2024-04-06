package GenericTree;

/**
 * levelOrderTraversal
 */
//remove the ele from queue, print it, then add its children
import java.util.*;;

public class levelOrderTraversal {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {
        }

        Node(int val) {
            this.data = val;
        }
    }

    static void printLevelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node removed = queue.poll();
            System.out.print(removed.data + " ");
            for (Node child : removed.children) {
                queue.add(child);
            }
        }
    }

    static void printLevelOrderLineWise(Node node) {
        Queue<Node> mainQueue = new ArrayDeque<>();
        Queue<Node> childQueue = new ArrayDeque<>();
        mainQueue.add(node);
        while (!mainQueue.isEmpty()) {
            Node removed = mainQueue.poll();
            System.out.print(removed.data + " ");

            for (Node child : removed.children) {
                childQueue.add(child);
            }

            if (mainQueue.size() == 0) {
                mainQueue = childQueue;
                childQueue = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    static void printLevelOrderLineWiseBetter(Node node) {// better approach
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
                    queue.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }

    static void printLevelOrderLineWise2(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node removed = queue.poll();
                System.out.print(removed.data + " ");
                for (Node child : removed.children) {
                    queue.add(child);
                }
            }
            System.out.println();
        }
    }

    static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static void printLevelOrderLineWiseUsingPair(Node node) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(node, 1));
        int level = 1;
        while (!queue.isEmpty()) {
            Pair removedPair = queue.poll();
            if (level < removedPair.level) {
                level = removedPair.level;
                System.out.println();
            }
            System.out.print(removedPair.node.data + " ");
            for (Node child : removedPair.node.children) {
                queue.add(new Pair(child, level + 1));
            }
        }
    }

    static void printLevelOrderSpiral(Node node) {
        Stack<Node> mainStack = new Stack<>();
        Stack<Node> childStack = new Stack<>();
        int level = 1;
        mainStack.add(node);
        while (!mainStack.isEmpty()) {
            Node removed = mainStack.pop();
            System.out.print(removed.data + " ");

            if (level % 2 == 1) {
                for (int i = 0; i < removed.children.size(); i++) {
                    childStack.add(removed.children.get(i));// for odd adding left to right, so that it pops right to
                                                            // left
                }
            } else {
                for (int i = removed.children.size() - 1; i >= 0; i--) {
                    childStack.add(removed.children.get(i));// for even adding right to left, so that it pops left to
                                                            // right.
                }
            }

            if (mainStack.isEmpty()) {
                mainStack = childStack;
                childStack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root = null;
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
                    root = newNode;
                    st.push(newNode);
                }
            }
        }
        // printLevelOrder(root);
        // System.out.println();
        // printLevelOrderLineWise(root);
        // System.out.println();
        // printLevelOrderSpiral(root);
        // printLevelOrderLineWiseBetter(root);
        // printLevelOrderLineWise2(root);
        printLevelOrderLineWiseUsingPair(root);
    }
}