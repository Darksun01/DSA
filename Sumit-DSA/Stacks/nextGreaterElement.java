package Stacks;

/**
 * nextGreaterElement
 */
import java.util.*;

//Next Greater Element to the right
public class nextGreaterElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findNextGreaterElement(arr);
        System.out.println();
        alternativeSol(arr);
        sc.close();
    }

    private static void findNextGreaterElement(int[] arr) {
        // In this approach we iterate from back. We check if stack.peek > arr[i] if it
        // is then next greater ele of arr[i] is stack.peek.
        // If it is not then we keep popping until we find an ele greater than than i'th
        // ele in the stack. then the nge of i'th ele becomes stack.peek.
        // If the stack becomes empty before we have found a next greter ele then we
        // will put -1 as the i'th elements next greter element.
        // for ex -> 2 5 9 3 1 12 6. we iterate from the back.
        // i = 6. since stack is empty. 6 is pushed. since stack is empty therefore
        // result[n-1] = -1.
        // i = 5. 12 > 6 , i.e 6 will be popped. now the stack becomes empty there next
        // greater elemnt of 12 is -1, result[n-2] = -1. 12 is pushed.
        // i = 4. 1 < 12. since stack.peek i.e 12 > than arr[i] i.e 1 there next greater
        // elemnt of 1 is 12. result[n-3] = 12. 1 will be pushed.
        // i = 3. 3 > 1, 3 < 12. 1 will be popped now stack.peek is 12 which is > 3.
        // therefore next greater element of 3 is 12. result[n-4] = 12. 3 will be
        // pushed.
        // i = 2. 9 > 3, 9 < 12. 3 will be popped now stack.peek is 12 which is > 9.
        // therefore next greater element of 9 is 12. result[n-5] = 12. 9 will be
        // pushed.
        // i = 1. 9 > 5. since stack.peek(9) > arr[i](5), therefore next greater element
        // of 5 is 9. result[n-6] = 9. 5 will be pushed.
        // i = 0. 5 > 2. since stack.peek(5) > arr[i](2), therefore next greater element
        // of 2 is 5. result[n-6] = 5. 2 will be pushed.
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (!st.isEmpty()) {
                while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                    st.pop();
                }
                result[i] = st.size() > 0 ? st.peek() : -1;
                st.push(i);
            } else {
                result[i] = -1;
                st.push(i);
            }
        }

        for (int ele : result) {
            System.out.print(ele + " ");
        }
    }

    private static void alternativeSol(int[] arr) {
        // in this approach we iterate from the left. We push the first ele index and
        // then start iterating.
        // We pop the index of the element if the ele on the top of stack is smaller
        // than the i'th ele, i.e if arr[i] > arr[stack.peek()].
        // we push the i'th index regardless of the conditions outcome.
        // then for the index left in the stack we mark their next gretaer element as
        // -1.
        // for ex- > 2 5 9 3 1 12 6. 0[2's index] will be pushed then we start
        // iterating.
        // i = 1 -> 2 < 5 , i.e nge[0] = 1. 0 will be popped. i will be pushed.
        // i = 2 -> 5 < 9 , i.e nge[1] = 9. 1 will be popped. i will be pushed.
        // i = 3 -> 9 > 3, i.e nge[2] = 0, as it is. i.e 0. nothing will be popped. i
        // will be pushed.
        // i = 4 -> 3 > 1, i.e nge[3] = 0, as it is. i.e 0. nothing will be popped. i
        // will be pushed.
        // i = 5 -> 1 < 12, 3 < 12, 9 < 12, i.e nge[2] = 12,nge[3] = 12,nge[4] = 12. 2,
        // 3, 4 all popped. i will be pushed.
        // i = 6 -> 6 < 12, nge[6] = 0, as it is. i.e 0. nothing will be popped. i will
        // be pushed.
        // stack contains -> 6[6],5[12]. now we will update their index in gre array as
        // -1. (i[i'th ele])
        int n = arr.length;
        int[] nge = new int[n]; // next greater element array
        Stack<Integer> st = new Stack<>();

        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                int pos = st.pop();
                nge[pos] = arr[i];
            }
            st.push(i);

        }

        while (!st.isEmpty()) {
            int pos = st.pop();
            nge[pos] = -1;
        }

        for (int i : nge) {
            System.out.print(i + " ");
        }
    }
}
