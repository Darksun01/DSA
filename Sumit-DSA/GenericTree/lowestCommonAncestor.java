package GenericTree;

/**
 * lowestCommonAncestor
 */
import java.util.*;

public class lowestCommonAncestor {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // find lca of d1 and d2. if d2 is child of d1 then d1 is lca
    static int getLowestCommonAncestor(Node node, int d1, int d2) {
        // the list returned are reversed. so if node root is 10 and ele to find is =
        // 120, then node to roolt path will be [120,80,30,10]
        ArrayList<Integer> list1 = getNodeToRootPath(node, d1);
        ArrayList<Integer> list2 = getNodeToRootPath(node, d2);
        int lca = 0;
        int i = list1.size() - 1, j = list2.size() - 1;
        // suppose we get 2 list s like [110,80,30,10] & [70,30,10], now there are 2
        // common ancestors but we will choose 1st one
        // therefore until list1[i]==list2[j] we do i-- & j--.
        while (i >= 0 && j >= 0 && list1.get(i) == list2.get(j)) {
            i--;
            j--;
        }
        i++;// since we decrease if we get list1(i)=list2(j) therefore the while loop will
            // terminate when list1(i)!=list2(j) and since we need the first common ancestor
            // therefore we do i++
        lca = list1.get(i);
        return lca;
    }

    private static ArrayList<Integer> getNodeToRootPath(Node node, int val) {
        if (node.data == val) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(val);
            return list;
        }
        for (Node child : node.children) {
            ArrayList<Integer> res = getNodeToRootPath(child, val);
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

        int lca = getLowestCommonAncestor(root, 80, 70);
        System.out.println(lca);
    }
}
