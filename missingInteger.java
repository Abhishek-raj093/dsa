import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];
        int length = nums.length;

        Set<Integer> storage = new HashSet<>();

        for (int num : nums) {
            storage.add(num);
        }

        int index = 1;

        while (index < length && nums[index] == nums[index - 1] + 1) {
            prefixSum += nums[index];
            index++;
        }

        while (storage.contains(prefixSum)) {
            prefixSum++;
        }

        return prefixSum;
    }
}