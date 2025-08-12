package GFG;

import java.util.Stack;
import java.util.ArrayList;

public class Solution {
    public Solution() {}
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        stack.push(x);
        if (minstack.isEmpty() || x <= minstack.peek()) {
            minstack.push(x);
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            if (!minstack.isEmpty() && popped == minstack.peek()) {
                minstack.pop();
            }
        }
        // code here
    }

    // Returns top element of the Stack
    public int peek() {
        // code here
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    // Finds minimum element of Stack
    public int getMin() {
        // code here
        if (minstack.isEmpty()) return -1;
        return minstack.peek();
    }

    // Returns an ArrayList where result[k-1] is the maximum of minimums of all windows of size k
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(ans[i]);
        }
        return list;
    }
}
