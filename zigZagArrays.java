import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[] dp = new long[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            long[] pref = new long[m];
            pref[0] = dp[0];
            for (int j = 1; j < m; j++) {
                pref[j] = (pref[j - 1] + dp[j]) % MOD;
            }
            long[] newDp = new long[m];
            if (i % 2 == 0) {
                for (int j = 1; j < m; j++) {
                    newDp[j] = pref[j - 1];
                }
            } else {
                long total = pref[m - 1];
                for (int j = 0; j < m - 1; j++) {
                    newDp[j] = (total - pref[j] + MOD) % MOD;
                }
            }
            dp = newDp;
        }
        long ans = 0;
        for (long x : dp) {
            ans = (ans + x) % MOD;
        }
        return (int)(ans * 2 % MOD);
    }
}