package graphs;

public class floodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        boolean[][]vis=new boolean[n][m];
        int x=image[sr][sc];
        drawTreeComponent(sr,sc,vis,image,color,x);
        return image;
    }
    public void drawTreeComponent(int i,int j,boolean[][] vis,int [][]image,int color,int x){
        if(i>=image.length || j>=image[0].length|| j<0 || i<0 || vis[i][j]
        ){
            return;
        }
        if(vis[i][j] || image[i][j]!=x)return;
        vis[i][j]=true;
        image[i][j]=color;
        drawTreeComponent(i-1,j,vis,image,color,x);
        drawTreeComponent(i+1,j,vis,image,color,x);
        drawTreeComponent(i,j-1,vis,image,color,x);
        drawTreeComponent(i,j+1,vis,image,color,x);
    }
}
