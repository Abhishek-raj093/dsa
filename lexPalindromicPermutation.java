class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;

        int odd = 0, mid = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) { odd++; mid = i; }
        }
        if (n % 2 == 0 && odd != 0) return "";
        if (n % 2 == 1 && odd != 1) return "";

        int half = n / 2;
        int[] left = new int[26];
        for (int i = 0; i < 26; i++) left[i] = count[i] / 2;

        int[] copy = left.clone();
        int matched = 0;
        boolean fullMatch = true;
        for (int i = 0; i < half; i++) {
            int c = target.charAt(i) - 'a';
            if (copy[c] == 0) { fullMatch = false; break; }
            copy[c]--;
            matched++;
        }

        if (fullMatch) {
            String firstHalf = target.substring(0, half);
            String answer = build(firstHalf, mid, n);
            if (answer.compareTo(target) > 0) return answer;
        }

        int[] use = left.clone();
        for (int i = 0; i < matched; i++) use[target.charAt(i) - 'a']--;

        for (int pos = Math.min(matched, half - 1); pos >= 0; pos--) {
            if (pos < matched) use[target.charAt(pos) - 'a']++;

            int tChar = target.charAt(pos) - 'a';
            for (int c = tChar + 1; c < 26; c++) {
                if (use[c] > 0) {
                    use[c]--;
                    String firstHalf = target.substring(0, pos) + (char) ('a' + c);
                    StringBuilder rest = new StringBuilder();
                    for (int x = 0; x < 26; x++)
                        for (int k = 0; k < use[x]; k++)
                            rest.append((char) ('a' + x));
                    return build(firstHalf + rest, mid, n);
                }
            }
        }

        return "";
    }

    private String build(String firstHalf, int mid, int n) {
        String reversed = new StringBuilder(firstHalf).reverse().toString();
        if (n % 2 == 1) return firstHalf + (char) ('a' + mid) + reversed;
        return firstHalf + reversed;
    }
}