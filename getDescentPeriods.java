class Solution {
    public int numberOfWays(String corridor) {
        int MOD = (int) 1e9 + 7;
        long ans = 1;
        int cnt = 0, prev = -1;
        
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                cnt++;
                if (cnt % 2 == 1 && cnt > 2) {
                    ans = ans * (i - prev) % MOD;
                }
                if (cnt % 2 == 0) prev = i;
            }
        }
        
        return cnt % 2 == 0 && cnt > 0 ? (int)ans : 0;
    }
}