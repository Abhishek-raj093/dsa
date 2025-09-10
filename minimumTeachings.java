import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> usersToTeach = new HashSet<>();
        
        
        for (int[] f : friendships) {
            int u1 = f[0], u2 = f[1];
            boolean canCommunicate = false;
            
            for (int l1 : languages[u1 - 1]) {
                for (int l2 : languages[u2 - 1]) {
                    if (l1 == l2) {
                        canCommunicate = true;
                        break;
                    }
                }
                if (canCommunicate) break;
            }
            
            if (!canCommunicate) {
                usersToTeach.add(u1);
                usersToTeach.add(u2);
            }
        }
        
      
        if (usersToTeach.isEmpty()) return 0;
        
        int[] freq=new int[n+1];
        for(int user:usersToTeach){
            for(int lang:languages[user-1]){
                freq[lang]++;
            }
        }
        Arrays.sort(freq);
        return usersToTeach.size()-freq[n];
}
}
