import java.util.HashMap;

class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (k == 1) {
            int ans = -1;

            for (int i = 0; i < nums.length; i++) {
                if (map.get(nums[i]) == 1 && nums[i] > ans) {
                    ans = nums[i];
                }
            }

            return ans;
        }

        else if (k == nums.length) {
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                max = Math.max(nums[i], max);
            }

            return max;
        }

        else {
            int first = nums[0];
            int last = nums[nums.length - 1];

            boolean first_count = map.get(first) == 1;
            boolean second_count = map.get(last) == 1;

            if (first_count && second_count)
                return Math.max(first, last);

            if (first_count)
                return first;

            if (second_count)
                return last;

            return -1;
        }
    }
}