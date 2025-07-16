class Solution {
    public int maximumLength(int[] nums) {
        int[] dp = new int[nums.length];
        int evens = 0;
        int odds = 0;
        int idxEven = -1;
        int idxOdd = -1;
        int res = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        if ((nums[0] & 1) == 1) {
            odds = 1;
            idxOdd = 0;
        } else {
            evens = 1;
            idxEven = 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                odds++;
                if (idxEven != -1) {
                    dp[i] = dp[idxEven] + 1;
                }
                idxOdd = i;
            } else {
                evens++;
                if (idxOdd != -1) {
                    dp[i] = dp[idxOdd] + 1;
                }
                idxEven = i;
            }

            int max = Math.max(evens, odds);
            res = Math.max(res, Math.max(max, dp[i]));
        }

        return res;
    }
}