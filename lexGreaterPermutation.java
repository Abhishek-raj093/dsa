class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int p = 0;

        while (p < n) {
            int c = target.charAt(p) - 'a';

            if (cnt[c] == 0) {
                break;
            }

            cnt[c]--;
            p++;
        }

        int i = p;

        while (i >= 0) {
            if (i < n) {
                int t = target.charAt(i) - 'a';
                int pick = -1;

                for (int c = t + 1; c < 26; c++) {
                    if (cnt[c] > 0) {
                        pick = c;
                        break;
                    }
                }

                if (pick >= 0) {
                    cnt[pick]--;

                    StringBuilder tail = new StringBuilder();

                    for (int c = 0; c < 26; c++) {
                        for (int j = 0; j < cnt[c]; j++) {
                            tail.append((char)('a' + c));
                        }
                    }

                    cnt[pick]++;

                    return target.substring(0, i)
                        + (char)('a' + pick)
                        + tail.toString();
                }
            }

            i--;

            if (i >= 0) {
                cnt[target.charAt(i) - 'a']++;
            }
        }

        return "";
    }
}