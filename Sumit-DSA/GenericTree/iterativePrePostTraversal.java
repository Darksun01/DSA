package GenericTree;

/**
 * iterativePrePostTraversal
 */
import java.util.*;

public class iterativePrePostTraversal {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static class Pair {
        Node node;
        int state;

        Pair() {
        }

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    // we have taken state variable to keep track of pre and post.
    // state == -1 means we have to print node in pre tarversal.
    // state == node.children.size() means that we have traversed all its children
    // and now we print it in post trversal and pop it.
    // else means we are traversing node's children.
    static void printPrePostIteratively(Node node) {
        Stack<Pair> st = new Stack<>();
        st.add(new Pair(node, -1));

        String Pre = "";
        String Post = "";
        while (!st.isEmpty()) {
            Pair topPair = st.peek();
            if (topPair.state == -1) {
                Pre += topPair.node.data + " ";
                topPair.state++;
            } else if (topPair.state == topPair.node.children.size()) {
                Post += topPair.node.data + " ";
                st.pop();
            } else {
                Node childNode = topPair.node.children.get(topPair.state);
                st.push(new Pair(childNode, -1));
                topPair.state++;
            }
        }

        System.out.println("PreOrder Traversal: " + Pre);
        System.out.println("PostOrder Traversal: " + Post);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Stack<Node> st = new Stack<>();
        Node root = null;

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
        printPrePostIteratively(root);
    }
}