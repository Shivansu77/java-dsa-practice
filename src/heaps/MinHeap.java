package heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a Min Heap data structure
 */
public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * Get the parent index of a node
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Get the left child index of a node
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Get the right child index of a node
     */
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * Swap two elements in the heap
     */
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Insert a new element into the heap
     */
    public void insert(int key) {
        heap.add(key);
        int i = heap.size() - 1;

        // Fix the min heap property if it is violated
        while (i != 0 && heap.get(parent(i)) > heap.get(i)) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    /**
     * Heapify the subtree rooted at index i
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
     * Extract the minimum element from the heap
     */
    public int extractMin() {
        if (heap.size() <= 0) {
            throw new IllegalStateException("Heap is empty");
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int root = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapify(0);

        return root;
    }

    /**
     * Get the minimum element without removing it
     */
    public int getMin() {
        if (heap.size() <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    /**
     * Get the current size of the heap
     */
    public int size() {
        return heap.size();
    }

    /**
     * Check if the heap is empty
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Print the heap elements
     */
    public void printHeap() {
        System.out.println(heap);
    }

    /**
     * Main method for testing the MinHeap implementation
     */
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
