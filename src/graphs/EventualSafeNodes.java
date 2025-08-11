package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventualSafeNodes {

    // Returns a list of eventual safe nodes in ascending order
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // state: 0=unvisited, 1=visiting, 2=safe (visited and confirmed no cycle)
        int[] state = new int[V];
        List<Integer> safe = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (dfs(i, adj, state)) {
                safe.add(i);
            }
        }
        Collections.sort(safe);
        return safe;
    }

    // returns true if node is safe (i.e., no cycle reachable from it)
    private boolean dfs(int node, List<List<Integer>> adj, int[] state) {
        if (state[node] == 1) return false;   // back edge => cycle
        if (state[node] == 2) return true;    // already determined safe
        state[node] = 1; // mark visiting
        for (int nbr : adj.get(node)) {
            if (!dfs(nbr, adj, state)) return false;
        }
        state[node] = 2; // mark safe
        return true;
    }
}
