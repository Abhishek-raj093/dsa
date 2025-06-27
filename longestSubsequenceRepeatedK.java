class Solution {
    String r = "";
    List<Character> l = new ArrayList<>();

    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        for (char c = 'a'; c <= 'z'; c++)
            if (cnt[c - 'a'] >= k) l.add(c);
        dfs(s, "", k);
        return r;
    }

    void dfs(String s, String sub, int k) {
        if (sub.length() > 0 && !isSub(s, sub, k)) return;
        if (sub.length() > r.length()) r = sub;
        for (int i = l.size() - 1; i >= 0; i--) {
            String nxt = sub + l.get(i);
            dfs(s, nxt, k);
        }
    }

    boolean isSub(String s, String sub, int k) {
        int j = 0, rep = 0, sl = s.length(), subl = sub.length();
        for (int i = 0; i < sl; i++) {
            if (sl - i < (k - rep - 1) * subl) return false;
            if (s.charAt(i) == sub.charAt(j)) {
                if (++j == subl) {
                    j = 0;
                    if (++rep == k) return true;
                }
            }
        }
        return false;
    }
}