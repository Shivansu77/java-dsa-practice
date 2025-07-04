package hashMapsForTrees;

import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class verticalTraversal {

    public List<List<Integer>> verticalTraversal1(TreeNode node) {
        List<List<Integer>> ans = new ArrayList<>();
        if (node == null) return ans;

        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(node, 0, 0));

        int minCol = 0, maxCol = 0;

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode curr = t.node;
            int col = t.col;
            int row = t.row;

            map.putIfAbsent(col, new HashMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(curr.val);

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (curr.left != null) queue.offer(new Tuple(curr.left, col - 1, row + 1));
            if (curr.right != null) queue.offer(new Tuple(curr.right, col + 1, row + 1));
        }

        for (int col = minCol; col <= maxCol; col++) {
            List<Integer> list = new ArrayList<>();
            Map<Integer, List<Integer>> rows = map.get(col);
            List<Integer> sortedKeys = new ArrayList<>(rows.keySet());
            Collections.sort(sortedKeys);
            for (int row : sortedKeys) {
                List<Integer> values = rows.get(row);
                Collections.sort(values);
                list.addAll(values);
            }
            ans.add(list);
        }

        return ans;
    }

    static class Tuple {
        TreeNode node;
        int col, row;

        Tuple(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    // 🔷 Here's the main method to run and test the traversal
    public static void main(String[] args) {
        // Create the tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   6 5   7

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(6)),
                new TreeNode(3, new TreeNode(5), new TreeNode(7))
        );

        verticalTraversal vt = new verticalTraversal();
        List<List<Integer>> result = vt.verticalTraversal1(root);

        System.out.println(result); // Expected output: [[4], [2], [1, 5, 6], [3], [7]]
    }
}
