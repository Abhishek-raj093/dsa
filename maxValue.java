class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(e -> e[0]));
        int[] starts = new int[n], next_idx = new int[n];
        for (int i = 0; i < n; ++i) starts[i] = events[i][0];
        for (int i = 0; i < n; ++i)
            next_idx[i] = Arrays.binarySearch(starts, events[i][1] + 1) < 0
                ? -Arrays.binarySearch(starts, events[i][1] + 1) - 1
                : upperBound(starts, events[i][1]);
        long[] prev = new long[n+1], curr;
        for (int i = n - 1; i >= 0; --i)
            prev[i] = Math.max(prev[i+1], events[i][2]);
        long res = prev[0];
        for (int t = 2; t <= k; ++t) {
            curr = new long[n+1];
            for (int i = n - 1; i >= 0; --i) {
                long take = events[i][2];
                int j = next_idx[i];
                if (j <= n) take += prev[j];
                curr[i] = Math.max(curr[i+1], take);
            }
            res = Math.max(res, curr[0]);
            prev = curr;
        }
        return (int)res;
    }

    private int upperBound(int[] a, int key) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}