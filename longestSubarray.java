class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int ans = 1;
        int cnt = 0;

        // Find the maximum element in the array
        for(int i : nums){
            max = Math.max(i, max);
        }

        // Find the longest consecutive sequence of maximum elements
        for(int i : nums){
            if(i == max){
                cnt++;  // Increment count for consecutive max elements
            } else {
                ans = Math.max(cnt, ans);  // Update answer with current count
                cnt = 0;  // Reset count for new sequence
            }
        }
        ans = Math.max(cnt, ans);  // Handle case where array ends with max elements

        return ans;
    }
}