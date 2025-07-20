package graphs;

public class courseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);  // Edge: v → u (to take u, must take v)
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!dfs(i, visited, onPath, graph, dq)) {
                    return new int[0];  // cycle detected
                }
            }
        }

        // Convert deque to array
        int[] ans = new int[numCourses];
        int idx = 0;
        for (int course : dq) {
            ans[idx++] = course;
        }
        return ans;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] onPath,
                        List<List<Integer>> graph, Deque<Integer> dq) {
        visited[node] = true;
        onPath[node] = true;

        for (int nbr : graph.get(node)) {
            if (onPath[nbr]) return false; // cycle detected
            if (!visited[nbr]) {
                if (!dfs(nbr, visited, onPath, graph, dq)) {
                    return false;
                }
            }
        }

        onPath[node] = false;
        dq.addFirst(node);  // Reverse topological order
        return true;
    }
}
