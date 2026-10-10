class Solution {
    public int minInsertions(String s) {
        int cnt = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (cnt % 2 == 1) {
                    // if cnt of opening odd - means a closing is req now otherwise the seq will break. 
                    ans++;
                    cnt--;
                }
                cnt += 2;
            } else {
                cnt--;

                if (cnt < 0) {
                    ans++;
                    cnt = 1;
                }
            }
        }

        return ans + cnt;
    }
}