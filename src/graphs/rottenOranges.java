package graphs;

import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {
    static class Pair {
        int row, col, time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges to queue and count fresh ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1) fresh++;
            }
        }

        // Step 2: BFS
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int time = 0, count = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int t = p.time;
            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m
                        && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                    q.add(new Pair(nr, nc, t + 1));
                    vis[nr][nc] = 2;
                    count++;
                }
            }
        }

        return count == fresh ? time : -1;
    }
}
