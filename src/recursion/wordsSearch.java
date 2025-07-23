package recursion;

public class wordsSearch {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        char ch=word.charAt(0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==ch){
                    boolean[][]vis=new boolean[n][m];
                    if(solve(i,j,0,board,word,vis))return true;
                }
            }
        }
        return false;
    }
    public boolean solve(int row,int col,int idx,char[][] board, String word, boolean[][]vis){

        if(idx==word.length())return true;
        int n=board.length;
        int m=board[0].length;
        if(row<0 || col<0 || row>=n || col>=m || vis[row][col] || board[row][col]!=word.charAt(idx))return false;
        vis[row][col]=true;
        if(solve(row,col+1,idx+1,board,word,vis))return true;
        if(solve(row,col-1,idx+1,board,word,vis))return true;
        if(solve(row+1,col,idx+1,board,word,vis))return true;
        if(solve(row-1,col,idx+1,board,word,vis))return true;
        vis[row][col]=false;
        return false;
    }
}
