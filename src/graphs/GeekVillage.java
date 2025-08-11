package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GeekVillage {
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] chefAndWells(int n, int m, char c[][]) {
        int[][]ans=new int[n][m];
        boolean[][] vis=new boolean[n][m];
        Queue<Pair>q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]=='H'){
                    ans[i][j]=-1;
                }else{
                    ans[i][j]=0;
                }
                if(c[i][j]=='W'){
                    q.add(new Pair(i,j));
                    vis[i][j]=true;
                }
            }
        }
        int []dx={1,-1,0,0};
        int []dy={0,0,1,-1};
        int level=0;

        while(!q.isEmpty()){
            int size=q.size();
            level++;
            for(int i=0;i<size;i++){
                Pair cur=q.poll();
                for(int d=0;d<4;d++){
                    int nx=cur.x+dx[d];
                    int ny=cur.y+dy[d];
                    if(nx>=0 && ny>=0 && nx<n && ny<m && !vis[nx][ny] && c[nx][ny]!='N'
                            && c[nx][ny]!='W'){
                        vis[nx][ny]=true;
                        if(c[nx][ny]=='H'){
                            if(ans[nx][ny]==-1 || ans[nx][ny]> level*2)
                                ans[nx][ny]=level*2;
                        }
                        q.add(new Pair(nx,ny));
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]!='H'){
                    ans[i][j]=0;
                }
            }
        }
        return ans;
    }
}
