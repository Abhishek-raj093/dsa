class Solution {
    public long distributeCandies(int n, int limit) {
        int min = Math.max(0, n - 2 * limit); // Minimum candies first child can get
        int max = Math.min(n, limit);         // Maximum candies first child can get
        long ways = 0;

        for (int i = min; i <= max; i++) {
            int N = n - i; // Remaining candies after giving i to the first child

            // Calculate valid range for second child
            int minCh2 = Math.max(0, N - limit);
            int maxCh2 = Math.min(N, limit);

            ways += maxCh2 - minCh2 + 1;
        }

        return ways;
    }
}