package heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Array-backed Min Heap implementation.
 * Maintains the min-heap property: each parent is less than or equal to its children.
 *
 * - insert: O(log n)
 * - extractMin: O(log n)
 * - getMin: O(1)
 *
 * Uses a zero-based array representation:
 * parent(i) = (i - 1) / 2, left(i) = 2*i + 1, right(i) = 2*i + 2.
 */
public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    /** Get parent index for node at i. */
    private int parent(int i) { return (i - 1) / 2; }

    /** Get left child index for node at i. */
    private int leftChild(int i) { return 2 * i + 1; }

    /** Get right child index for node at i. */
    private int rightChild(int i) { return 2 * i + 2; }

    /** Swap two elements in the heap array. */
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Inserts a new key and percolates it up to restore heap order.
     */
    public void insert(int key) {
        heap.add(key);
        int i = heap.size() - 1;
        // Bubble up until the parent is <= current
        while (i != 0 && heap.get(parent(i)) > heap.get(i)) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    /**
     * Heapify (sift down) the subtree rooted at index i.
     */
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    /**
     * Removes and returns the minimum element (root).
     * Throws IllegalStateException if the heap is empty.
     */
    public int extractMin() {
        if (heap.size() <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        int root = heap.get(0);
        // Move last element to root and restore heap by sifting down
        heap.set(0, heap.remove(heap.size() - 1));
        heapify(0);
        return root;
    }

    /** Returns (without removing) the minimum element. */
    public int getMin() {
        if (heap.size() <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    /** Returns number of elements in the heap. */
    public int size() { return heap.size(); }

    /** Returns true if the heap has no elements. */
    public boolean isEmpty() { return heap.isEmpty(); }

    /** Prints the internal array representation of the heap. */
    public void printHeap() { System.out.println(heap); }

    /** Simple demonstration. */
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);

        System.out.println("Min Heap: ");
        minHeap.printHeap();
        System.out.println("The minimum element is: " + minHeap.getMin());
        System.out.println("Extracting the minimum element: " + minHeap.extractMin());
        System.out.println("Min Heap after extraction: ");
        minHeap.printHeap();
    }
}
