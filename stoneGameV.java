import java.util.*;

class Solution {
    public int stoneGameV(int[] arr) {
        int n=arr.length;
        int [] pre=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+arr[i];
        }

        Integer [][] dp=new Integer[n][n];

        return check(dp,0,n-1,pre);
    }

    public int check(Integer [][] dp,int low,int high,int []pre){
        if(low==high)
            return 0;

        if(dp[low][high]!=null)
            return dp[low][high];

        int ans=0;

        for(int i=low;i<high;i++){
            int left=(low==0)?pre[i]:pre[i]-pre[low-1];
            int right=pre[high]-pre[i];

            int alice=0;
            if(left>right){
                alice=right+check(dp,i+1,high,pre);
            }
            else if(left<right){
                alice=left+check(dp,low,i,pre);
            }
            else{
                alice=left+Math.max(
                    check(dp,low,i,pre),
                    check(dp,i+1,high,pre)
                );
            }
            ans=Math.max(alice,ans);
        }

        return dp[low][high]=ans;
    }
}