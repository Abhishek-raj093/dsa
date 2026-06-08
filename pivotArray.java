class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int i : nums) {
            if (i < pivot) 
                ans[idx++] = i;

        }

        for (int i : nums) {
            if (i == pivot) 
                ans[idx++] = i;
        }

        for (int i : nums) {
            if (i > pivot) 
                ans[idx++] = i;

        }
        return ans;
    }
}