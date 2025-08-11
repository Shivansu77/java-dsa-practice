package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorDirected {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[][] count = new int[n][26]; // count[node][color]
        int[] inDegree = new int[n];

        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph and compute in-degrees
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            inDegree[v]++;
        }

        // Topological Sort using Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        int res = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            int colorIndex = colors.charAt(node) - 'a';
            count[node][colorIndex]++;
            res = Math.max(res, count[node][colorIndex]);

            for (int nei : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    count[nei][c] = Math.max(count[nei][c], count[node][c]);
                }
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        return visited == n ? res : -1; // if cycle exists
    }
}
