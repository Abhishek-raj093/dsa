class Solution {
    public int maximumProduct(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return (int) Math.max(
            max1 * max2 * max3,
            max1 * min1 * min2
        );
    }
}