import java.util.*;

class Solution {
    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class State {
        long score;
        int[] arr;

        State(long score, int[] arr) {
            this.score = score;
            this.arr = arr;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        Interval[] a = new Interval[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(a, (x, y) -> {
            if (x.r != y.r) return Integer.compare(x.r, y.r);
            return Integer.compare(x.idx, y.idx);
        });

        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = a[i].r;
        }

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int pos = lowerBound(ends, a[i].l);
            prev[i] = pos;
        }

        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[0][k] = new State(0, new int[0]);
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                State best = dp[i - 1][k];

                if (k > 0) {
                    State before = dp[prev[i - 1]][k - 1];

                    int[] cur = new int[before.arr.length + 1];

                    for (int j = 0; j < before.arr.length; j++) {
                        cur[j] = before.arr[j];
                    }

                    cur[cur.length - 1] = a[i - 1].idx;

                    Arrays.sort(cur);

                    State take = new State(
                        before.score + a[i - 1].w,
                        cur
                    );

                    if (better(take, best)) {
                        best = take;
                    }
                }

                dp[i][k] = best;
            }
        }

        return dp[n][4].arr;
    }

    static int lowerBound(int[] ends, int target) {
        int lo = 0;
        int hi = ends.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (ends[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    static boolean better(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score;
        }

        return smaller(a.arr, b.arr);
    }

    static boolean smaller(int[] a, int[] b) {
        int n = Math.min(a.length, b.length);

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }

        return a.length < b.length;
    }
}