package GenericTree;

/**
 * nodeToRootPath
 */
import java.util.*;

public class nodeToRootPath {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static ArrayList<Integer> getRootToNodePath(Node node, int val) {
        if (node.data == val) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for (Node child : node.children) {
            ArrayList<Integer> res = getRootToNodePath(child, val);
            if (!res.isEmpty()) {
                res.add(node.data);
                return res;
            }
        }

        return new ArrayList<Integer>();
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
        ArrayList<Integer> nodeToPath = getRootToNodePath(root, 110);
        for (int i = 0; i < nodeToPath.size(); i++) {
            System.out.print(nodeToPath.get(i) + " ");
        }
    }
}
