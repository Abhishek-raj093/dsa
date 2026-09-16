class Solution {
    private static final long MOD = 1_000_000_007L;

    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }

    public int numberOfSets(int n, int k) {
        long N = n + k - 1;
        long R = 2L * k;

        if (R < 0 || R > N) return 0;
        R = Math.min(R, N - R);

        long num = 1, den = 1;
        for (long i = 1; i <= R; i++) {
            num = num * (N - R + i) % MOD;
            den = den * i % MOD;
        }

        return (int) (num * modPow(den, MOD - 2) % MOD);
    }
}