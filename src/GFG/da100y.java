package GFG;

import java.util.Stack;

public class da100y {
    static int maxLength(String s) {
        // code here
        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }else{
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen=Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }
}
