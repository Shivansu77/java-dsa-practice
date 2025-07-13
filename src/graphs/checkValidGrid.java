package graphs;

public class checkValidGrid {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        // Must start from (0, 0) with move 0
        if (grid[0][0] != 0) return false;

        return printKnightTour(grid, 0, 0, 0);
    }

    public static boolean printKnightTour(int[][] grid, int r, int c, int move) {
        int n = grid.length;

        // Boundary check
        if (r < 0 || c < 0 || r >= n || c >= n) return false;
        // Move number mismatch
        if (grid[r][c] != move) return false;

        // Last move reached
        if (move == n * n - 1) return true;

        // Try each knight move manually
        if (printKnightTour(grid, r - 2, c + 1, move + 1)) return true;
        if (printKnightTour(grid, r - 1, c + 2, move + 1)) return true;
        if (printKnightTour(grid, r + 1, c + 2, move + 1)) return true;
        if (printKnightTour(grid, r + 2, c + 1, move + 1)) return true;
        if (printKnightTour(grid, r + 2, c - 1, move + 1)) return true;
        if (printKnightTour(grid, r + 1, c - 2, move + 1)) return true;
        if (printKnightTour(grid, r - 1, c - 2, move + 1)) return true;
        if (printKnightTour(grid, r - 2, c - 1, move + 1)) return true;

        // No valid path, backtrack
        return false;
    }
}
