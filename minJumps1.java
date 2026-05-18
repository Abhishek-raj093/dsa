import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;
        if(n == 1) {
            return 0;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int current = queue.poll();
                if(current == n - 1) {
                    return steps;
                }
                List<Integer> neighbors = map.get(arr[current]);

                neighbors.add(current - 1);
                neighbors.add(current + 1);

                for(int next : neighbors) {
                    if(next >= 0 && next < n && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                map.get(arr[current]).clear();
            }
            steps++;
        }
        return -1;
    }
}