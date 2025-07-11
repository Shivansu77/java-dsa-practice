package graphs;

public class numIslandRec {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]vis=new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    drawTreeComponent(i,j,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void drawTreeComponent(int i,int j,boolean [][]vis ,char[][]grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j]==true || grid[i][j]=='0'){
            return;
        }
        vis[i][j]=true;
        drawTreeComponent(i-1,j,vis,grid);
        drawTreeComponent(i,j+1,vis,grid);
        drawTreeComponent(i,j-1,vis,grid);
        drawTreeComponent(i+1,j,vis,grid);
    }
}
