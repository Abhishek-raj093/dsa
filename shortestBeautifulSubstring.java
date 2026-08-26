import java.util.*;

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        if(s.length()<k) return "";

        int n = s.length();

        int l = 0;
        int cnt = 0;
        int mini = Integer.MAX_VALUE;
        int start = -1;

        for(int r=0;r<n;r++){
            char c = s.charAt(r);

            if(c=='1') cnt++;

            while(cnt==k){

                if((r-l+1)==mini){
                    // same length, keep the smaller one
                    if(check(s, start, l, mini)){
                        start = l;
                    }
                }
                else if((r-l+1)<mini){
                    mini = r-l+1;
                    start = l;
                }

                if(s.charAt(l)=='1') cnt--;
                l++;
            }
        }

        return start==-1 ? "" : s.substring(start, start+mini);
    }

    // true if window at 'start' is bigger than window at 'l'
    private boolean check(String s, int start, int l, int mini){
        int n = start+mini;
        int m = l+mini;

        while(start<n && l<m){
            if(s.charAt(start) > s.charAt(l)) return true;
            if(s.charAt(start) < s.charAt(l)) return false;

            start++;
            l++;
        }

        return false;
    }
}