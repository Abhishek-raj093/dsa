class Solution {
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int m = 0;

        for (int num : nums) {
            m = Math.max(m, num);
        }

        int[][] dp = new int[m + 1][m + 1];
        dp[0][0] = 1;

        for (int num : nums) {
            int[][] newDp = new int[m + 1][m + 1];

            for (int gcd1 = 0; gcd1 <= m; gcd1++) {
                int nextGcd1 = gcd(gcd1, num);

                for (int gcd2 = 0; gcd2 <= m; gcd2++) {
                    int ways = dp[gcd1][gcd2];

                    if (ways == 0) {
                        continue;
                    }

                    int nextGcd2 = gcd(gcd2, num);

                    newDp[gcd1][gcd2] =
                        (newDp[gcd1][gcd2] + ways) % MOD;

                    newDp[nextGcd1][gcd2] =
                        (newDp[nextGcd1][gcd2] + ways) % MOD;

                    newDp[gcd1][nextGcd2] =
                        (newDp[gcd1][nextGcd2] + ways) % MOD;
                }
            }

            dp = newDp;
        }

        int ans = 0;

        for (int gcd = 1; gcd <= m; gcd++) {
            ans = (ans + dp[gcd][gcd]) % MOD;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}