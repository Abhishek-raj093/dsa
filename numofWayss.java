class Solution {
    int mod = (int) 1e9 + 7;
    long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % mod;
            }
        }

        return (int) ((solve(nums) - 1 + mod) % mod);
    }

    private long solve(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return 1;
        }

        int root = nums[0];

        int leftCount = 0;
        int rightCount = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < root) {
                leftCount++;
            } else {
                rightCount++;
            }
        }

        int[] left = new int[leftCount];
        int[] right = new int[rightCount];

        int li = 0, ri = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < root) {
                left[li++] = nums[i];
            } else {
                right[ri++] = nums[i];
            }
        }

        long leftWays = solve(left);
        long rightWays = solve(right);

        long interleavings = comb[n - 1][leftCount];

        return (((interleavings * leftWays) % mod)
                * rightWays) % mod;
    }
}