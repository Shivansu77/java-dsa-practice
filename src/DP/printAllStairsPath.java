package DP;

import java.util.ArrayList;


public class printAllStairsPath {

    public static void main(String[] args) {
        printStairsPaths(5,"");
    }
    public static void printStairsPaths(int n,String path){
        if (n == 0) {
            System.out.println(path);
            return;
        }
        // base case: invalid path (overshoot)
        if (n < 0) {
            return;
        }
        printStairsPaths(n-1,path+"1");
        printStairsPaths(n-2,path+"2");
        printStairsPaths(n-3,path+"3");

    }
}
