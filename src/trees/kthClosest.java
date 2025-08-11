package trees;

import java.util.PriorityQueue;

public class kthClosest {
    public int[][] kClosest(int[][] points, int k) {
        // Max heap: largest distance at top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(distance(b), distance(a))
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove farthest
            }
        }

        // Prepare result array
        int[][] result = new int[k][2];
        int i = 0;
        for (int[] point : maxHeap) {
            result[i++] = point;
        }

        return result;
    }

    // Helper method to compute squared distance
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
