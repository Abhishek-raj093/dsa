import java.util.*;

class Solution {
    public boolean isvalid(int i, int j, int[] nums, int target){
        return (i < j) && (Math.abs(nums[i]-nums[j]) <= target);
    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i = n-2; i>= 0; i--){
            for(int j = i+1; j<n; j++){
                if(isvalid(i, j ,nums,target) && dp[j] != -1){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            if(dp[i] == 0)dp[i] = -1;
        }
        return dp[0];
    }
}