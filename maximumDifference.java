class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int mini = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mini = Math.min(mini, nums[i]);
            if (nums[i] > mini) 
                ans = Math.max(ans, nums[i] - mini);
        }
        return ans;
    }
}