import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];

        // Build graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        // dp[node][color] stores max count of color in any path ending at node
        int[][] dp = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        
        // Initialize queue with nodes having inDegree 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int visited = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            int colorIndex = colors.charAt(node) - 'a';
            dp[node][colorIndex]++;
            maxColorValue = Math.max(maxColorValue, dp[node][colorIndex]);

            for (int neighbor : graph.get(node)) {
                // Update dp for neighbor using current node's dp
                for (int c = 0; c < 26; c++) {
                    dp[neighbor][c] = Math.max(dp[neighbor][c], dp[node][c]);
                }
                // Decrease in-degree and add to queue if it becomes 0
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all nodes are visited, there's a cycle
        return visited == n ? maxColorValue : -1;
    }
}