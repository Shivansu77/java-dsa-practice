package graphs;

public class EventualSafeNodes {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer>safe=new ArrayList<>();
        // Your code here
        boolean[]vis=new boolean[V];
        ArrayList<Integer>path=new ArrayList<>();
        for(int i=0;i<V;i++)path.add(0);
        for(int i=0;i<V;i++){
            if(!vis[i]){
                detectCycle(i,adj,vis,path,safe);
            }
        }
        for(int i=0;i<path.size();i++){
            if(path.get(i)==0){
                safe.add(i);
            }
        }
        return safe;
    }
    public static boolean detectCycle(int node,List<List<Integer>> adj,boolean[] vis,
                                      ArrayList<Integer>path,List<Integer>safe){

        vis[node]=true;
        path.set(node,1);

        for(int nbr:adj.get(node)){
            if(!vis[nbr]){
                boolean cycle=detectCycle(nbr,adj,vis,path,safe);
                if(cycle){
                    return true;
                }
            }else{
                if(path.get(nbr)==1){
                    return true;
                }
            }
        }
        path.set(node,0);

        return false;
    }
}
