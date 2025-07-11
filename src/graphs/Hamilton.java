package graphs;

public class Hamilton {
    boolean check(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();


        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());

        }

        for(ArrayList<Integer> edge: edges){
            if(edge.size()<2)continue;
            int u=edge.get(0)-1;
            int v=edge.get(1)-1;
            if(u>=0 && u<n && u>=0 && v<n){
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }
        boolean[]vis=new boolean[n];
        //here we gonna find node
        for(int i=0;i<n;i++){
            if(dfs(i,adj,vis,1,n))return true;
        }
        return false;
    }

    boolean dfs(int node,ArrayList<ArrayList<Integer>>adj,boolean []vis,int c,int n){
        vis[node]=true;
        if(c==n)return true;

        for(int neighbor : adj.get(node)){
            if(!vis[neighbor]){
                if(dfs(neighbor,adj,vis,c+1,n)) return true;
            }
        }
        vis[node]=false;
        return false;

    }
}
