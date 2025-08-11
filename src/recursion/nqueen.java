package recursion;

import java.util.ArrayList;

/**
 * N-Queens backtracking solver.
 * Returns all valid placements of n queens on an n x n board so that no two queens attack each other.
 * Each solution is represented as a list of column indices (1-based) for each row from top to bottom.
 *
 * Example (n = 4): [[2, 4, 1, 3], [3, 1, 4, 2]]
 *
 * Time complexity: O(n!) in worst case; space: O(n^2) for board + recursion.
 */
public class nqueen {
    /**
     * Computes all valid N-Queens placements for a given n.
     */
    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solve(0, board, ans, n);
        return ans;
    }

    /**
     * Try to place a queen on each column of the current row and recurse.
     */
    public static void solve(int row, boolean[][] board, ArrayList<ArrayList<Integer>> ans, int n){
        // If all rows are filled, capture the current placement
        if (row == n) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        // store 1-based column index
                        list.add(j + 1);
                    }
                }
            }
            ans.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = true;      // choose
                solve(row + 1, board, ans, n); // explore
                board[row][col] = false;     // un-choose (backtrack)
            }
        }
    }

    /**
     * A position (row, col) is safe if no queen exists in the same column,
     * the upper-left diagonal, or the upper-right diagonal.
     */
    public static boolean isSafe(int row, int col, boolean[][] board, int n){
        // Check column above
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        // Check upper-left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) return false;
        }
        // Check upper-right diagonal
        int maxRight = Math.min(row, n - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(nQueen(4));
    }
}
