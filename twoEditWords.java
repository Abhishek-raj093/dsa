import java.util.*;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
      List<String>ans = new ArrayList<>();
      int n=queries.length;
      int m=dictionary.length;
      for(String it:queries){
        for(String dic:dictionary){
            int count=0;
          for(int i=0;i<dic.length();i++){
            if(it.charAt(i)!=dic.charAt(i)){
                count++;
            }
          }
          if(count<=2){
            ans.add(it);
            break;
          }
        }
    }
    return ans;
}
}