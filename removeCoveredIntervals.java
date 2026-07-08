import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length; 
        // 1. sort 
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return Integer.compare(b[1], a[1]); 
            return Integer.compare(a[0], b[0]); 
        }); 

        int en = intervals[0][1]; 
        int cnt = 0; 
        // 2. count covered 
        for(int i = 1; i < n; i++) {
            int e = intervals[i][1]; 
            if(e <= en) cnt++; 
            else en = e; 
        }

        return n - cnt; 
    }
}