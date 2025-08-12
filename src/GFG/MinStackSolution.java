package GFG;

import java.util.Stack;

// A standalone Min Stack implementation similar to the one in Solution.java,
// provided here because MinStackSolution was previously empty.
// Methods follow the same semantics:
// - push(int x)
// - pop()
// - peek(): returns -1 if empty
// - getMin(): returns -1 if empty
public class MinStackSolution {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minstack = new Stack<>();

    // Add an element to the top of the stack
    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty() || x <= minstack.peek()) {
            minstack.push(x);
        }
    }

    // Remove the top element from the stack
    public void pop() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            if (!minstack.isEmpty() && popped == minstack.peek()) {
                minstack.pop();
            }
        }
    }

    // Returns top element of the stack; -1 if empty
    public int peek() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    // Finds minimum element of the stack; -1 if empty
    public int getMin() {
        if (minstack.isEmpty()) return -1;
        return minstack.peek();
    }
}
