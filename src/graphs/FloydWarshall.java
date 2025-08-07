package graphs;
import java.util.*;

class FloydWarshall {
    static final int INF = Integer.MAX_VALUE;

    static void floydWarshall(int[][] graph) {
        int n = graph.length;
        long[][] dist = new long[n][n];
        int[][] next = new int[n][n];

        // Initialize dist and next
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] < INF) {
                    dist[i][j] = graph[i][j];
                    next[i][j] = j;
                } else {
                    dist[i][j] = Long.MAX_VALUE / 2;
                    next[i][j] = -1;
                }
            }
            dist[i][i] = 0;
            next[i][i] = i;
        }

        // Core Floyd–Warshall loops
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        // Negative-cycle detection: check diagonal
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Graph contains a negative‑weight cycle");
                return;
            }
        }

        // Print distance and paths
        printAllPaths(dist, next);
    }

    static List<Integer> getPath(int i, int j, int[][] next) {
        if (next[i][j] == -1) return Collections.emptyList();
        List<Integer> path = new ArrayList<>();
        path.add(i);
        while (i != j) {
            i = next[i][j];
            path.add(i);
        }
        return path;
    }

    static void printAllPaths(long[][] dist, int[][] next) {
        int n = dist.length;
        System.out.println("Pair    Dist    Path");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    List<Integer> path = getPath(i, j, next);
                    String p = path.isEmpty() ? "—" : path.toString();
                    System.out.printf("%d -> %d    %4d    %s%n", i, j, dist[i][j], p);
                }
            }
        }
    }

    public static void main(String[] args) {
        int I = Integer.MAX_VALUE;
        int[][] graph = {
                {0, I, -2, I},
                {4, 0, 3, I},
                {I, I, 0, 2},
                {I, -1, I, 0}
        };
        floydWarshall(graph);
    }
}
