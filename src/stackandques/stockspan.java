package stackandques;

import java.util.ArrayList;
import java.util.Stack;

public class stockspan {
    class Pair{
        int stock;
        int span=1;
        Pair(int stock,int span){
            this.stock=stock;
            this.span=span;
        }
    }
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek().stock <= arr[i]) {
                span += stack.pop().span;
            }
            stack.push(new Pair(arr[i], span));
            list.add(span);
        }
        return list;
    }
}
