package graphs;

public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>graph=new ArrayList<>();
        boolean[]vis=new boolean[numCourses];
        boolean[]path=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
            vis[i]=false;
            path[i]=false;
        }
        for(int []edge: prerequisites){
            int u=edge[0];
            int v=edge[1];
            graph.get(v).add(u);
        }
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(!dfs(i,vis,graph,path)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node,boolean[]vis,List<List<Integer>>graph,boolean[]path){
        vis[node]=true;
        path[node]=true;
        for(int nbr:graph.get(node)){
            if(path[nbr])return false;
            if(!vis[nbr]){
                if(!dfs(nbr,vis,graph,path)){
                    return false;
                }
            }
        }
        path[node]=false;
        return true;
    }
}
