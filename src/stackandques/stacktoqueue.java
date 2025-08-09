package stackandques;

public class stacktoqueue {
    Stack<Integer> stack1;  // Input stack
    Stack<Integer> stack2;  // Output stack
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        shiftStacksIfNeeded();
        return stack2.pop();
    }

    public int peek() {
        shiftStacksIfNeeded();
        return stack2.peek();
    }

    public boolean empty() {
        shiftStacksIfNeeded();
        return stack1.isEmpty() && stack2.isEmpty();
    }
    private void shiftStacksIfNeeded() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
