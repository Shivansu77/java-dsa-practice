package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public ArrayList<Integer> bfsG(ArrayList<ArrayList<Integer>> adj) {
        int n=adj.size();
        ArrayList<Integer>result=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        boolean []vis=new boolean[n];
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            result.add(node);
            for(int v:adj.get(node)){
                if(!vis[v]){
                    vis[v]=true;
                    q.add(v);
                }
            }
        }
    return result;
    }
}
