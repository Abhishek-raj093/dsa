import java.util.*;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int actual=1<<k;
        if(s.length()-k+1<actual){
            return false;
        }
        Set<String> set=new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            set.add(s.substring(i,i+k));
        }
        return set.size()==actual;
    }
}