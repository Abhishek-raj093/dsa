import java.util.*;

class Solution {
    public int maxDistance2(int side, int[][] points, int k) {
        // Step 1: unwrap each point to 1D arc position
        long perimeter = 4L * side;
        long[] pos = new long[points.length];
        for (int i = 0; i < points.length; i++) {
            pos[i] = toArc(points[i][0], points[i][1], side);
        }
        Arrays.sort(pos);
        int n = pos.length;

        // Step 2: binary search on minimum distance
        long lo = 1, hi = perimeter / k, ans = 0;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (canPlace(pos, n, k, mid, perimeter)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int) ans;
    }

    // Map 2D boundary point → 1D clockwise arc distance from (0,0)
    private long toArc(int x, int y, int side) {
        if (y == 0)           return x;                        // bottom: left→right
        if (x == side)        return side + y;                 // right:  bottom→top
        if (y == side)        return 2L * side + (side - x);  // top:    right→left
        /*  x == 0 */         return 3L * side + (side - y);  // left:   top→bottom
    }

    // Greedy check: can we place k points all >= minDist apart (circular)?
    private boolean canPlace(long[] pos, int n, int k, long minDist, long perimeter) {
        // Try each point as the starting point
        for (int start = 0; start < n; start++) {
            int count = 1;
            long prev  = pos[start];
            int idx    = start;

            while (count < k) {
                // find next pos >= prev + minDist (with wrap-around)
                int next = findNext(pos, n, prev + minDist, idx, start);
                if (next == -1) break;
                prev = pos[next];
                idx  = next;
                count++;
            }

            // Check wrap-around: last point back to first must also be >= minDist
            if (count == k) {
                long wrapDist = pos[start] + perimeter - prev;
                if (wrapDist >= minDist) return true;
            }
        }
        return false;
    }

    // Binary search: find index of first pos >= target, after 'after', before wrapping to 'startIdx'
    private int findNext(long[] pos, int n, long target, int after, int startIdx) {
        // Search in [after+1, n-1]
        int lo = after + 1, hi = n - 1, result = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (pos[mid] >= target) { result = mid; hi = mid - 1; }
            else lo = mid + 1;
        }
        // Valid only if it doesn't reach or pass startIdx (no full wrap needed here)
        if (result != -1 && result != startIdx) return result;
        return -1;
    }
}