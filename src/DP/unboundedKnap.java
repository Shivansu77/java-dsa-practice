package DP;

public class unboundedKnap {
    static int knapSack(int val[], int wt[], int cap) {
        // code here
        int n=val.length;
        int []dp=new int[cap+1];
        for(int i=1;i<=cap;i++){
            int max=0;
            for(int j=0;j<n;j++){
                if(wt[j]<=i){
                    int rbag=i-wt[j];
                    int rbagv=dp[rbag];
                    int tbagv=rbagv+val[j];
                    if(tbagv>max){
                        max=tbagv;
                    }
                }
            }
            dp[i]=max;
        }
        return dp[cap];
    }
}

