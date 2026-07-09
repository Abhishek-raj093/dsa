class Solution {
    public int[] sumAndMultiply0(String s, int[][] queries) {
        final long MOD = 1_000_000_007;
        int n = s.length();

        long[] prefixNum = new long[n+1];
        long[] prefixSum = new long[n+1];
        int[] nonZeroCount = new int[n+1];
        long[] pow10 = new long[n+1];

        pow10[0] = 1;

        for(int i=1; i<=n; i++) {
            pow10[i] = (pow10[i-1] * 10) % MOD;
        }

        for(int i=0; i<n; i++) {
            int digit = s.charAt(i) - '0';

            prefixSum[i+1] = prefixSum[i] + digit;
            nonZeroCount[i+1] = nonZeroCount[i];
            
            if(digit != 0) {
                prefixNum[i+1] = (prefixNum[i] * 10 + digit) % MOD;
                nonZeroCount[i+1]++;
            } else {
                prefixNum[i+1] = prefixNum[i];
            }
        }

        int[] res = new int[queries.length];

        for(int q=0; q<queries.length; q++) {
            int left = queries[q][0];
            int right = queries[q][1];

            long sum = (prefixSum[right+1] - prefixSum[left]) % MOD;
            int digits = nonZeroCount[right+1] - nonZeroCount[left];
            long num = (prefixNum[right+1] - (prefixNum[left] * pow10[digits]) % MOD + MOD) % MOD;

            res[q] = (int) ((num * sum) % MOD);
        }

        return res;
    }
} 