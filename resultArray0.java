class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;

        if (k == 1) {
            return new long[]{(long) n * (n + 1) / 2};
        }

        long[] ans = new long[k];
        long[] freq = new long[k];

        for (int x : nums) {
            int r = x % k;
            long[] freq2 = new long[k];

            ans[r]++;

            for (int j = 0; j < k; j++) {
                int prod = (j * r) % k;

                freq2[prod] += freq[j];
                ans[prod] += freq[j];
            }

            freq2[r]++;
            freq = freq2;
        }

        return ans;
    }
}