class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        if (n == 0){
            return values[0] * values[1] * values[2];
        }
        int[][] dp = new int[n][n];
        for (int d = 2; d < n; d++){
            for (int i = 0; i + d < n; i++){
                int j = i + d;
                int e = values[i] * values[j];
                int best = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++){
                    int cand = e * values[k] + dp[i][k] + dp[k][j];
                    best = Math.min(best, cand);
                }
                dp[i][j] = best;
            }
        }
        return dp[0][n - 1];
    }
}