package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class pathwithmin {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        // Direction vectors: up, down, left, right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Min-heap based on effort
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0}); // {x, y, effort}

        // Visited/effort tracker
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], effort = curr[2];

            if (x == m - 1 && y == n - 1) return effort;

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int currEffort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (currEffort < dist[nx][ny]) {
                        dist[nx][ny] = currEffort;
                        pq.offer(new int[]{nx, ny, currEffort});
                    }
                }
            }
        }

        return 0; // Shouldn't reach here
    }
}
