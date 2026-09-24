import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int smallestIndex(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int res = 0;

            while (nums[i] > 0) {
                res += nums[i] % 10;
                nums[i] /= 10;
            }

            if (res == i) {
                ans.add(i);
            }
        }

        Collections.sort(ans);

        if (ans.isEmpty()) {
            return -1;
        } else {
            return ans.get(0);
        }
    }
}