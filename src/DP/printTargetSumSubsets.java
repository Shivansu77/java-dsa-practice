package DP;

public class printTargetSumSubsets {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50}; // example array
        int target = 60; // example target sum
        printTargetSumSubset(arr, 0, "", 0, target);
    }
    public static void printTargetSumSubset(int []arr,int idx,String set,int sos,int tar){
        if(idx==arr.length){
            if(sos==tar){
                System.out.println(set.substring(0,set.length()-1));
            }
            return;
        }
        printTargetSumSubset(arr,idx+1,set+arr[idx]+",",sos+arr[idx],tar);
        printTargetSumSubset(arr,idx+1,set,sos,tar);

    }
}
