import java.util.*;

class Solution {
    public int findGCD1(int[] nums) {
        int minNum = nums[0];
        int maxNum = nums[0];

        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        while (maxNum != 0) {
            int temp = maxNum;
            maxNum = minNum % maxNum;
            minNum = temp;
        }

        return minNum;
    }
}