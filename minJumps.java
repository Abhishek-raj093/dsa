import java.util.*;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        
        if (n == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++){
            int x = nums[i];
        
            for (int p = 2; p * p <= x; p++){
                if (x % p == 0){
                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                    while (x % p == 0) x /= p;
                }
            }
            if (x > 1) map.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        Set<Integer> used = new HashSet<>();
        q.offer(0);
        vis[0] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                if (i == n - 1) return steps;
                if (i - 1 >= 0 && !vis[i - 1]){
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }
                if (i + 1 < n && !vis[i + 1]){
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }
                if (isPrime(nums[i])){
                    int p = nums[i];

                    if (used.add(p)){
                        for (int next : map.getOrDefault(p, Collections.emptyList())){
                            if (!vis[next]){
                                vis[next] = true;
                                q.offer(next);
                            }
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private boolean isPrime(int x){
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) if (x % i == 0) return false;
        return true;
    }
}