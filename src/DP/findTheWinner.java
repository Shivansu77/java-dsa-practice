package DP;

import java.util.Deque;
import java.util.LinkedList;

public class findTheWinner {
    public static int findWinner(int n, int k) {
       Deque<Integer> dq=new LinkedList<>();
       for(int i=1;i<=n;i++){
           dq.addLast(i);
       }
       while(dq.size()>1){
           for(int i=1;i<k;i++){
               dq.addLast(dq.removeFirst());
           }
           dq.removeFirst();
       }
       return dq.peek();
    }

    public static void main(String[] args) {
        System.out.println(findWinner(5,2));
    }
}
