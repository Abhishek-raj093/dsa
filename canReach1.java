import java.util.*;

class Solution {
    public boolean canReach1(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1')
            return false;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int reach = 0;
        for (int i = 1; i < n; i++) {
            if (i - minJump >= 0) {
                reach += dp[i - minJump] ? 1 : 0;
            }
            if (i - maxJump - 1 >= 0) {
                reach -= dp[i - maxJump - 1] ? 1 : 0;
            }
            if (reach > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }
        return dp[n - 1];
    }
}