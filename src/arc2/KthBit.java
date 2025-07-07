package arc2;

public class KthBit {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0'; // base case

        int length = (1 << n) - 1; // total length of Sn
        int mid = (length / 2) + 1;

        if (k == mid) return '1'; // middle bit is always '1'

        if (k < mid) {
            // First half: same as findKthBit(n-1, k)
            return findKthBit(n - 1, k);
        } else {
            // Second half: it's reverse(invert(Sn-1)), so we find mirrored index and invert the bit
            int mirroredIndex = length - k + 1;
            char bit = findKthBit(n - 1, mirroredIndex);
            return invert(bit);
        }
    }

    private char invert(char bit) {
        return bit == '0' ? '1' : '0';
    }
}
