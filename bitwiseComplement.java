import java.util.*;

class Solution {
    public int bitwiseComplement(int n) {
        if(n==0)return 1;
        int ans=0,track=1;
        while(n>0){
            int curBit=n&1;
            if(curBit==0){
                ans+=track;
            }
            track<<=1;
            n>>=1;
        }
        return ans;
    }
}