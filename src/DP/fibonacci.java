package DP;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       System.out.print(fibmemoized(n,new int[n+1]));

    }
   /* public static int fib(int n){Recursion used here
        if(n<=1){
            return n;
        }
        int fib1=fib(n-1);
        int fib2=fib(n-2);
        return fib1+fib2;
    }*/
    public static int fibmemoized(int n,int []qb){
        if(n<=1)return n;
        if(qb[n]!=0){
            return qb[n];
        }
        int fib1=fibmemoized(n-1,qb);
        int fib2=fibmemoized(n-2,qb);
        int fib=fib1+fib2;
        qb[n]=fib;
        return fib;
    }
}
