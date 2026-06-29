import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int zigZagArrays1(int n, int l, int r) {

        int m = r - l + 1;

        // Base vector
        long[] up = new long[m];

        for (int i = 0; i < m; i++)
            up[i] = i;

        // Transition matrix
        long[][] T = new long[m][m];

        for (int i = 1; i < m; i++) {

            long[] row = T[i]; // Cache row reference

            for (int j = m - i; j < m; j++)
                row[j] = 1;
        }

        // Fast exponentiation
        long[][] power = matPow(T, n - 2, m);

        long ans = 0;

        for (int i = 0; i < m; i++) {

            long[] row = power[i]; // Cache row reference

            for (int j = 0; j < m; j++) {

                if (row[j] == 0)
                    continue; // Skip useless work

                ans = (ans + row[j] * up[j]) % MOD;
            }
        }

        return (int) ((ans << 1) % MOD);
    }

    private long[][] matMul(long[][] A, long[][] B, int sz) {

        long[][] C = new long[sz][sz];

        for (int i = 0; i < sz; i++) {

            long[] aRow = A[i];
            long[] cRow = C[i];

            for (int k = 0; k < sz; k++) {

                long a = aRow[k];

                // Skip zero entries
                if (a == 0)
                    continue;

                long[] bRow = B[k];

                for (int j = 0; j < sz; j++) {

                    long b = bRow[j];

                    if (b == 0)
                        continue;

                    cRow[j] = (cRow[j] + a * b) % MOD;
                }
            }
        }

        return C;
    }

    private long[][] matPow(long[][] M, int p, int sz) {

        long[][] res = new long[sz][sz];

        // Identity matrix
        for (int i = 0; i < sz; i++)
            res[i][i] = 1;

        while (p > 0) {

            if ((p & 1) == 1)
                res = matMul(res, M, sz);

            M = matMul(M, M, sz);

            p >>= 1;
        }

        return res;
    }
}