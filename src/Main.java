import graphs.sdu;
import stackandques.nextGreater;
import stackandques.stockspan;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Demo 1: Stock Span
        stockspan ss = new stockspan();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        ArrayList<Integer> spans = ss.calculateSpan(prices);
        System.out.println("Stock Span for " + Arrays.toString(prices) + " => " + spans);

        // Demo 2: Next Greater Element
        nextGreater nge = new nextGreater();
        int[] arr = {4, 5, 2, 25};
        ArrayList<Integer> ng = nge.nextLargerElement(arr);
        System.out.println("Next Greater Elements for " + Arrays.toString(arr) + " => " + ng);

        // Demo 3: Disjoint Set Union (Union-Find)
        sdu dsu = new sdu(5); // 0..4
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);
        System.out.println("Find(0) == Find(2)? " + (dsu.find(0) == dsu.find(2)));
        System.out.println("Find(0) == Find(3)? " + (dsu.find(0) == dsu.find(3)));

        System.out.println("Demo completed.");
    }
}
