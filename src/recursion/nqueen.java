package recursion;

import java.util.ArrayList;

public class nqueen {
    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        boolean[][]board=new boolean[n][n];
        solve(0,board,ans,n);
        return ans;
    }
    public static void solve(int row, boolean[][]board, ArrayList<ArrayList<Integer>>ans,int n){

        if(row==n){
            ArrayList<Integer>list=new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        list.add(j+1);
                    }
                }
            }
            ans.add(list);
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(row,col,board,n)){
                board[row][col]=true;
                solve(row+1,board,ans,n);
                board[row][col]=false;

            }
        }

    }
    public static boolean isSafe(int row,int col,boolean[][]board,int n){
        for(int i=0;i<row;i++){
            if(board[i][col])return false;
        }
        int maxLeft=Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i])return false;
        }
        int maxRight=Math.min(row,n-col-1);
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i])return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(nQueen(4));
    }
}
