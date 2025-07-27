package graphs;

public class snakesAndLadder {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int node = 1;
        boolean flag = true;

        // Flatten the 2D board into a 1D connection list
        List<Integer> connection = new ArrayList<>(Collections.nCopies(n * n + 1, -1));
        for (int i = n - 1; i >= 0; i--) {
            if (flag) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != -1) {
                        connection.set(node, board[i][j]);
                    }
                    node++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (board[i][j] != -1) {
                        connection.set(node, board[i][j]);
                    }
                    node++;
                }
            }
            flag = !flag;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        queue.offer(1); // Start from square 1
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // Level size (same move count)
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n * n)
                    return moves;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n)
                        continue;

                    // Jump if ladder/snake
                    if (connection.get(next) != -1) {
                        next = connection.get(next);
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1; // Cannot reach the end
    }
}
