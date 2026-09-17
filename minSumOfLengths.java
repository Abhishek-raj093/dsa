class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int res = n + 1;
        int total = 0;
        int i = 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);

        for (int j = 0; j < n; j++) {
            total += arr[j];

            while (total > target) {
                total -= arr[i];
                i++;
            }

            dp[j + 1] = dp[j];

            if (total == target) {
                int len = j - i + 1;

                res = Math.min(res, len + dp[i]);
                dp[j + 1] = Math.min(dp[j], len);
            }
        }

        return res == n + 1 ? -1 : res;
    }
}