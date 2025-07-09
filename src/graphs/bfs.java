package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS {
    /**
     * Performs BFS traversal on a graph represented as adjacency list.
     * Starts BFS from node 0.
     *
     * @param adj adjacency list of the graph
     * @return list of nodes in BFS traversal order
     */
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean[] visited = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // Start BFS from node 0
        visited[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return ans;
    }
}
