class Solution {
    private final int MOD = 1000000007;
    private static final int MAX_SIZE = 100000;
    private static final long[] INVERSES = new long[MAX_SIZE];
    private static final int[] FACTORIALS = new int[MAX_SIZE];

    public int countGoodArrays(int n, int m, int k) {
        if (FACTORIALS[0] == 0) {
            FACTORIALS[0] = 1;
        }

        long result = (long) m * power(m - 1, n - 1 - k) % MOD * combinations(n - 1, k) % MOD;
        return (int) result;
    }

    private long power(int base, int exponent) {
        long res = 1;
        long b = base;  
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                res = res * b % MOD;
            }
            b = b * b % MOD;
            exponent >>>= 1; 
        }
        return res;
    }

    private long combinations(int a, int b) {
        if (b < 0 || b > a) return 0;

        return (long) factorial(a) * inverse(factorial(a - b)) % MOD * inverse(factorial(b)) % MOD;
    }

    private int factorial(int a) {
        if (FACTORIALS[a] != 0) {
            return FACTORIALS[a];
        }

        for(int i = 1; i <= a; ++i){
            if(FACTORIALS[i] == 0){
              FACTORIALS[i] = (int) ((long)FACTORIALS[i - 1] * i % MOD);
            }
        }
        return FACTORIALS[a];
    }

    private long inverse(long a) {
        if (a == 1) {
            return a;
        }
        return MOD - MOD / a * inverse(MOD % a) % MOD;
    }
}