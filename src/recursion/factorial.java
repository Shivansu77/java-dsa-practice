package recursion;

/**
 * Simple demonstration of computing factorial using recursion.
 *
 * <p>Definition:
 * n! = n * (n-1)! with base case 0! = 1 and 1! = 1.
 *
 * <p>Notes:
 * - This implementation handles n >= 0. For n < 0 it throws IllegalArgumentException.
 * - Time complexity: O(n), space complexity: O(n) due to call stack depth.
 */
public class factorial {
    /**
     * Returns n! for n >= 0.
     *
     * @param n non-negative integer
     * @return factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static int fact(int n){
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is undefined for negative numbers: " + n);
        }
        // Base cases: 0! = 1 and 1! = 1
        if(n == 0 || n == 1) return 1;
        // Recurrence: n! = n * (n-1)!
        int fnt1 = fact(n - 1);
        int fn = fnt1 * n;
        return fn;
    }
    public static void main(String[] args) {
        System.out.println(fact(5)); // prints 120
        System.out.println(fact(0)); // prints 1
    }
}
