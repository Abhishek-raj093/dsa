class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n][n + 1];
        int[] suffixSum = new int[n];

        suffixSum[n - 1] = piles[n - 1];

        for (int x = n - 2; x >= 0; x--) {
            suffixSum[x] = suffixSum[x + 1] + piles[x];
        }

        for (int x = n - 1; x >= 0; x--) {
            for (int y = 1; y <= n; y++) {
                if (x + 2 * y >= n) {
                    dp[x][y] = suffixSum[x];
                } else {
                    for (int j = 1; j <= 2 * y; j++) {
                        dp[x][y] = Math.max(
                            dp[x][y],
                            suffixSum[x] -
                            dp[x + j][Math.max(y, j)]
                        );
                    }
                }
            }
        }

        return dp[0][1];
    }
}