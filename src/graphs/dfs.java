package graphs;

public class dfs {

        public ArrayList<Integer> dfs1(ArrayList<ArrayList<Integer>> adj) {
            int n=adj.size();
            ArrayList<Integer>result=new ArrayList<>();
            boolean []vis=new boolean[n];

            for(int i=0;i<n;i++){
                if(!vis[i]){
                    helper(i,result,adj,vis);
                }
            }
            return result;
        }
        public void helper(int i,ArrayList<Integer>result,ArrayList<ArrayList<Integer>> adj,boolean []vis){
            vis[i]=true;
            result.add(i);
            for(Integer v:adj.get(i)){
                if(!vis[v]){
                    helper(v,result,adj,vis);
                }
            }
        }

}
