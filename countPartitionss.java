class Solution {
    public int countPartitionss(int[] nums, int k) {
        int n = nums.length;
        long mod = 1_000_000_007L;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        TreeMap<Integer, Integer> cnt = new TreeMap<>();

        dp[0] = prefix[0] = 1;

        int j = 0;

        for (int i = 0; i < n; i++) {

            // insert nums[i] into the multiset
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);

            // slide j while window violates max-min > k
            while (cnt.lastKey() - cnt.firstKey() > k) {
                int val = nums[j];
                int c = cnt.get(val) - 1;

                if (c == 0) cnt.remove(val);
                else cnt.put(val, c);

                j++;
            }

            long left = (j > 0 ? prefix[j - 1] : 0);
            dp[i + 1] = (prefix[i] - left + mod) % mod;

            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }

        return (int) dp[n];
    }
}