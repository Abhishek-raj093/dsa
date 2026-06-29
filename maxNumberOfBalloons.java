import java.util.*;

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[]freq=new int[26];
        for(char ch:text.toCharArray()){
            freq[ch-'a']++;
        }
        String str="balloon";
        int res=0,i=0;
        while(i<str.length()){
            char ch=str.charAt(i);
            if(freq[ch-'a']==0) break;
            else if( freq[ch-'a']>0 && i == str.length()-1){
                res++;
            }
            freq[ch-'a']--;
            i++;
            if(i==str.length()) i=0;
        }
        return res;
    }
}