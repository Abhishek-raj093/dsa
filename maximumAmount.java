import java.util.*;

class Solution {
    int m,n;
    int[][][] dp;
    public int maximumAmount(int[][] coins) {
        m=coins.length;
        n=coins[0].length;
        // dp[i][j][shield] = max coins from (i,j) with remaining shields
        dp=new int[m][n][3];
        for(int[][] i:dp){
            for(int[] j:i){
                Arrays.fill(j,Integer.MIN_VALUE/2);
            }
        }
        return find(0,0,2,coins);
    }
    // Directions: Right,Down
    int[] row={0,1};
    int[] col={1,0};

    public int find(int i,int j,int shield,int[][] arr){
        if(i>=m || j>=n){
            return Integer.MIN_VALUE/2;
        }
        // If reached destination (bottom-right cell)
        if(i==m-1 && j==n-1){
            if(shield>0 && arr[i][j]<0){
                return 0;
            }
            return arr[i][j];
        }
        // Return memoized result if already computed
        if(dp[i][j][shield]!=Integer.MIN_VALUE/2) return dp[i][j][shield];
        int ans=Integer.MIN_VALUE/2;
        // Try both directions: right and down
        for(int d=0;d<2;d++){
            int skp=Integer.MIN_VALUE/2;
            // Use shield if current cell is negative and shield is available
            if(shield>0 && arr[i][j]<0){
                skp=find(i+row[d],j+col[d],shield-1,arr);
            }
            // Do not use shield (or if no shield available)e
            int nskp=arr[i][j]+find(i+row[d],j+col[d],shield,arr);
            ans = Math.max(ans, Math.max(skp, nskp));
        }
        // Store result in DP (memoization)
        return dp[i][j][shield]=ans;
    }
}