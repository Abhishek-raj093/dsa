import java.util.*;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int count[] = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[target.charAt(i) - 'a']--;
        }
        char t[] = target.toCharArray();
        for(int i = s.length() - 1; i >= 0; i--) {
            int b = t[i] - 'a';
            count[b]++;
            if(Arrays.stream(count).min().getAsInt() < 0) continue;
            for(int j = b + 1; j < 26; j++) {
                if(count[j] > 0) {
                    count[j]--;
                    t[i] = (char) ('a' + j);
                    return new String(t, 0, i + 1) + getMinString(count);
                }
            }
        }
        return "";
    }
    private String getMinString(int count[]) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 26; i++) result.append(String.valueOf((char)('a' + i)).repeat(count[i]));
        return result.toString();
    }
}