import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        // dp[i] stores a pair: (length of subsequence ending at i, list of indices)
        int[] dpLen = new int[n];
        List<Integer>[] dpSeq = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            dpLen[i] = 1;
            dpSeq[i] = new ArrayList<>();
            dpSeq[i].add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && dpLen[j] + 1 > dpLen[i]) {
                    dpLen[i] = dpLen[j] + 1;
                    dpSeq[i] = new ArrayList<>(dpSeq[j]);
                    dpSeq[i].add(i);
                }
            }
        }

        // Find the sequence with max length
        int maxLen = 0;
        List<Integer> bestSeq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dpLen[i] > maxLen) {
                maxLen = dpLen[i];
                bestSeq = dpSeq[i];
            }
        }

        // Convert indices to words
        List<String> result = new ArrayList<>();
        for (int index : bestSeq) {
            result.add(words[index]);
        }

        return result;
    }
}
