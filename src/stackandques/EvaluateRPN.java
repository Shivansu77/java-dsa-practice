package stackandques;

import java.util.Stack;

public class EvaluateRPN {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        for (String ch : arr) {
            if (ch.matches("-?\\d+")) {
                stack.push(Integer.parseInt(ch));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (ch) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
