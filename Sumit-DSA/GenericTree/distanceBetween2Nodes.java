package GenericTree;

/**
 * distanceBetween2Nodes
 */
import java.util.*;

public class distanceBetween2Nodes {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static ArrayList<Integer> getNodeToRootPath(Node node, int val) {
        if (node.data == val) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
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

    static Integer getDistance(Node node, int d1, int d2) {
        // the list returned are reversed. so if node root is 10 and ele to find is =
        // 120, then node to roolt path will be [120,80,30,10]
        ArrayList<Integer> list1 = getNodeToRootPath(node, d1);
        ArrayList<Integer> list2 = getNodeToRootPath(node, d2);

        // suppose we get 2 list s like [110,80,30,10] & [70,30,10], now there are 2
        // common ancestors but we will choose 1st one
        // therefore until list1[i]==list2[j] we do i-- & j--.
        int i = list1.size() - 1, j = list2.size() - 1;
        while (i >= 0 && j >= 0 && list1.get(i) == list2.get(j)) {
            i--;
            j--;
        }
        // since we decrease if we get list1(i)=list2(j) therefore the while loop will
        // terminate when list1(i)!=list2(j) and since we need the first common ancestor
        // therefore we do i++
        i++;
        j++;
        // [110,80,30,10] & [70,30,10] in these list after line 46 i=2,j=1, adding them
        // gives us the distance b/w 110 & 70
        return i + j;
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
        int distance = getDistance(root, 20, 110);
        System.out.println(distance);
    }
}