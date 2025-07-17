package graphs;

public class LongestCycleInaGraph {
    int longestLength=-1;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        boolean []vis=new boolean[n];
        List<Integer>path=new ArrayList<>();
        for(int i=0;i<n;i++)path.add(0);
        for(int i=0;i<n;i++){
            if(!vis[i]){
                detectCycle(1,i,vis,path,edges);
            }
        }
        return longestLength;
    }
    public void detectCycle(int c,int node,boolean[]vis,List<Integer>path,int[] edges){
        c++;
        vis[node]=true;
        path.set(node,c);
        int nbr=edges[node];
        if(nbr!=-1){
            if(!vis[nbr]){
                detectCycle(c,nbr,vis,path,edges);
            }else if(path.get(nbr)!=0){
                int cycleLen=path.get(node)-path.get(nbr)+1;
                longestLength=Math.max(cycleLen,longestLength);
            }
        }
        path.set(node,0);
    }
}
