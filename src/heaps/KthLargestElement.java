package heaps;

/**
 * Problem: Find the kth largest element in an array
 * 
 * This is a common problem that can be efficiently solved using a min heap.
 * We maintain a min heap of size k, and for each element in the array:
 * - If the heap size is less than k, we add the element to the heap
 * - If the element is larger than the smallest element in the heap, we remove the smallest
 *   element and add the new element
 * 
 * After processing all elements, the smallest element in the heap is the kth largest element
 * in the array.
 */
public class KthLargestElement {
    
    /**
     * Find the kth largest element in the array
     * 
     * @param nums the input array
     * @param k the k value
     * @return the kth largest element
     */
    public static int findKthLargest(int[] nums, int k) {
        // Create a min heap
        MinHeap minHeap = new MinHeap();
        
        for (int num : nums) {
            // If the heap size is less than k, add the element
            if (minHeap.size() < k) {
                minHeap.insert(num);
            } 
            // If the element is larger than the smallest element in the heap,
            // remove the smallest and add the new element
            else if (num > minHeap.getMin()) {
                minHeap.extractMin();
                minHeap.insert(num);
            }
        }
        
        // The smallest element in the heap is the kth largest element
        return minHeap.getMin();
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        System.out.println("Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int kthLargest = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + kthLargest);
        
        // Test with another example
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        
        System.out.println("\nArray: ");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        kthLargest = findKthLargest(nums2, k);
        System.out.println("The " + k + "th largest element is: " + kthLargest);
    }
}