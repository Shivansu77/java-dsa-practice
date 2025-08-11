package graphs;

import java.util.ArrayList;
import java.util.List;

class MakeConnected {
    public int makeConnected1(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        List<List<Integer>> graph = new ArrayList<>();
        boolean[]vis=new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int component=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,graph);
                component++;
            }
        }
        return component-1;
    }
    public void dfs(int node,boolean[]vis,List<List<Integer>> graph ){
        vis[node]=true;
        for(int nbr:graph.get(node)){
            if(!vis[nbr]){
                dfs(nbr,vis,graph);
            }
        }
    }
}
