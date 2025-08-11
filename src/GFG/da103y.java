package GFG;

import java.util.Stack;

public class da103y {
    static int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        stack.clear();
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int wid = (right[i] - left[i] - 1);
            int area = arr[i] * wid;
            max = Math.max(max, area);
        }
        return max;
    }
}
