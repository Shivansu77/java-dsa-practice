package stackandques;

public class stockspan {
    class pair{
        int stock;
        int span=1;
        pair(int stock,int span){
            this.stock=stock;
            this.span=span;
        }
    }
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer>list=new ArrayList<>();
        Stack<pair>stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            int span=1;

            while(!stack.isEmpty() && stack.peek().stock<=arr[i]){
                span+=stack.pop().span;

            }
            stack.push(new pair(arr[i],span));
            list.add(span);

        }
        return list;

    }
}
