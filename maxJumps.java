import java.util.*;

class Solution {
    public int maxJumps(int[] arr, int d) {
        int ans = 0;
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, dfs(i, arr, n, dp, d));
        if (ans == 0)
            return 1;
        return ans;
    }

    public int dfs(int i, int[] arr, int n, int[] dp, int d) {
        if (dp[i] != 0)
            return dp[i];
        
        int k = Math.min(i + d + 1, n);
        int m = 1;
        for (int j = i + 1; j < k; j++)
            if (arr[j] >= arr[i])
                break;
            else
                m = Math.max(m, 1 + dfs(j, arr, n, dp, d));
        k = Math.max(0, i - d);
        for (int j = i - 1; j >= k; j--) 
            if (arr[j] >= arr[i])
                break;
            else
                m = Math.max(m, 1 + dfs(j, arr, n, dp, d));
        dp[i] = m;
        return m;
    }   
}