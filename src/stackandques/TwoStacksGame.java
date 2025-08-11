package stackandques;

import java.util.List;

public class TwoStacksGame {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int sum = 0;
        int i = 0, j = 0;
        int count = 0;

        // Take as many from b as possible
        while (j < b.size() && sum + b.get(j) <= maxSum) {
            sum += b.get(j);
            j++;
        }

        count = j;

        // Now try taking from a, adjusting b if needed
        while (i < a.size()) {
            sum += a.get(i);
            i++;

            while (sum > maxSum && j > 0) {
                j--;
                sum -= b.get(j);
            }

            if (sum <= maxSum) {
                count = Math.max(count, i + j);
            } else {
                break; // Can't add more from a
            }
        }

        return count;
    }
}
