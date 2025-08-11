package GFG;

import java.util.Stack;

public class da99y {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character>stack=new Stack<>();
        for(char ch:s.toCharArray() ){
            if(ch=='[' || ch=='{' || ch=='('){
                stack.push(ch);
            }
            else if(ch==']'){
                if(stack.isEmpty() || stack.pop()!='[')return false;
            }
            else if(ch=='}'){
                if(stack.isEmpty() || stack.pop()!='{')return false;
            }
            else if(ch==')'){
                if(stack.isEmpty() || stack.pop()!='(')return false;
            }
        }
        return stack.isEmpty();
    }
}
