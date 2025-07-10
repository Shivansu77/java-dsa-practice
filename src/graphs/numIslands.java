package graphs;

public class numIslands {
    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {
        // Check for edge case: empty grid
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        // Traverse the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If land and not visited, start a BFS
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(i, j, visited, grid);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public void bfs(int startRow, int startCol, boolean[][] visited, char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        visited[startRow][startCol] = true;
        queue.add(new Pair(startRow, startCol));

        // Directions: 8 neighbors (including diagonals)
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};


        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == '1' &&
                        !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}
