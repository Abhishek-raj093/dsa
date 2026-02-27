import java.util.*;

class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();

        int one=0,zero=0;
        for(char ch : s.toCharArray()){
            if(ch=='0') zero++;
            else one++;
        }
        if(zero==0) return 0;
        if(zero==k) return 1;
        if(k==1) return zero;
        if(k>=n) return -1;

        for(int ans=2 ; ans<=n ; ans++){
            int change = ans*k;

            if(change<zero) continue;
            if((change-zero)%2==1) continue;

            if(change==zero) return ans;

            if((ans&1)==1 && (zero + (ans-1)*n >= change)) return ans;
            else if((ans&1)==0 && (zero+(ans-2)*n + one*2) >= change) return ans;
        }
        return -1;
    }
}