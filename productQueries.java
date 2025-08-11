class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> power = new ArrayList<>();
        
        while (n > 0) {
            int m = 1;
            while (n >= (m << 1)) {
                m <<= 1;
            }
            power.add(m);
            n -= m;
        }
        
        Collections.sort(power);
        int k = power.size();
        int MOD = 1000000007;

        long[][] dp = new long[k][k];
        for (int i = 0; i < k; i++) {
            dp[i][i] = power.get(i);
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                dp[i][j] = (dp[i][j - 1] * power.get(j)) % MOD;
            }
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            ans[i] = (int) dp[a][b];
        }
        
        return ans;
    }
}