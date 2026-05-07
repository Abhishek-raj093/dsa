import java.util.*;

class Solution {
    public int[] maxValue3(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int prev = nums[0], suf = nums[n-1];
        for (int i = 0; i < n; i++)
            pre[i] = prev = Math.max(prev, nums[i]);
        for (int i = n - 2; i >= 0; i--) {
            if (pre[i] > suf)  pre[i] = pre[i + 1];
            suf = Math.min(nums[i], suf);
        }
        return pre;
    }
}