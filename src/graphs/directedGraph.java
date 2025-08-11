package graphs;

import java.util.ArrayList;
import java.util.List;

public class directedGraph {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());

        for(int[]edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] vis=new boolean[V];
        List<Integer>current_path=new ArrayList<>();
        for(int i=0;i<V;i++)current_path.add(0);

        for(int i=0;i<V;i++){
            if(!vis[i]){
                boolean cycle= detectCycle(i,adj,vis,current_path);
                if(cycle){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean detectCycle(int node,List<List<Integer>>adj,boolean[] vis, List<Integer>current_path){
        vis[node]=true;
        current_path.set(node,1);
        for(int nbr:adj.get(node)){
            if(!vis[nbr]){
                boolean cycle=detectCycle(nbr,adj,vis,current_path);
                if(cycle)return true;
            }else{
                if(current_path.get(nbr)==1){
                    return true;
                }
            }
        }
        current_path.set(node,0);
        return false;

    }
}
