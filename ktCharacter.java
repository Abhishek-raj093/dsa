

class Solution {

    public char kthCharacter(long k, int[] operations) {
        int res = 0;
        int bitIndex;
        while (k != 1) {
            bitIndex = 63 - Long.numberOfLeadingZeros(k);
            if ((1L << bitIndex) == k) {
                bitIndex--;
            }
            k = k - (1L << bitIndex);
            if (operations[bitIndex] != 0) {
                res++;
            }
        }
        return (char) ('a' + (res % 26));
    }
}
