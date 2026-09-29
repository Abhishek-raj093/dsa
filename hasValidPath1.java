import java.math.BigInteger;
class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int lim = (m + n) >> 1;

        if (((m + n) & 1) == 0 ||
            grid[0][0] == ')' ||
            grid[m - 1][n - 1] == '(')
            return false;

        BigInteger maxMask = BigInteger.ONE.shiftLeft(lim + 1)
                                          .subtract(BigInteger.ONE);

        BigInteger[] dp = new BigInteger[n];

        for (int i = 0; i < n; i++)
            dp[i] = BigInteger.ZERO;

        dp[0] = BigInteger.ONE.shiftLeft(1);

        int p = 1;

        for (int j = 1; j < n; j++) {
            p += grid[0][j] == '(' ? 1 : -1;

            if (p < 0 || p > lim) break;

            dp[j] = BigInteger.ONE.shiftLeft(p);
        }

        p = 1;

        for (int i = 1; i < m; i++) {
            p += grid[i][0] == '(' ? 1 : -1;

            if (dp[0].equals(BigInteger.ZERO) || p < 0 || p > lim)
                dp[0] = BigInteger.ZERO;
            else
                dp[0] = BigInteger.ONE.shiftLeft(p);

            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1].or(dp[j]);

                if (grid[i][j] == '(')
                    dp[j] = dp[j].shiftLeft(1).and(maxMask);
                else
                    dp[j] = dp[j].shiftRight(1);
            }
        }

        return dp[n - 1].testBit(0);
    }
}