package recursion;

/**
 * Word Search (Backtracking)
 *
 * Determines whether a given word exists in a 2D board of characters. The word can be
 * constructed from letters of sequentially adjacent cells (horizontally or vertically),
 * with the constraint that the same cell may not be used more than once.
 *
 * Example:
 * board = [[A,B,C,E],
 *          [S,F,C,S],
 *          [A,D,E,E]], word = "ABCCED" -> true
 *
 * Time complexity: O(N * M * 4^L) in the worst case, where L = word length.
 * Space complexity: O(N * M) for the visited matrix and recursion stack.
 */
class WordsSearch {
    /**
     * Returns true if the word exists in the board.
     */
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char first = word.charAt(0);
        // Try to start from every cell that matches the first character
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == first) {
                    boolean[][] vis = new boolean[n][m];
                    if (solve(i, j, 0, board, word, vis)) return true;
                }
            }
        }
        return false;
    }

    /**
     * Backtracking search from position (row, col) matching word[idx:].
     */
    public boolean solve(int row, int col, int idx, char[][] board, String word, boolean[][] vis){
        // If all characters have been matched, the word is found
        if (idx == word.length()) return true;

        int n = board.length;
        int m = board[0].length;
        // Boundary checks, already visited, or character mismatch -> fail this path
        if (row < 0 || col < 0 || row >= n || col >= m || vis[row][col] || board[row][col] != word.charAt(idx))
            return false;

        // Mark the current cell as visited to avoid reuse in this path
        vis[row][col] = true;

        // Explore 4-directionally: right, left, down, up
        if (solve(row, col + 1, idx + 1, board, word, vis)) return true;
        if (solve(row, col - 1, idx + 1, board, word, vis)) return true;
        if (solve(row + 1, col, idx + 1, board, word, vis)) return true;
        if (solve(row - 1, col, idx + 1, board, word, vis)) return true;

        // Backtrack: unmark the cell before returning
        vis[row][col] = false;
        return false;
    }
}
