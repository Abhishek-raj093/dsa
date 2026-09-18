import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < 26; c++) {
            if (last[c] == -1) continue;

            int left = first[c];
            int right = last[c];

            boolean valid = true;

            for (int i = left; i <= right; i++) {
                int ch = s.charAt(i) - 'a';

                if (first[ch] < left) {
                    valid = false;
                    break;
                }

                right = Math.max(right, last[ch]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        Collections.sort(intervals, (a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];

            if (left > prevEnd) {
                ans.add(s.substring(left, right + 1));
                prevEnd = right;
            }
        }

        return ans;
    }
}