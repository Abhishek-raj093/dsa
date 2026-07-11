class Solution {
    int edge;
    int node;

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int count = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            edge = 0;
            node = 0;

            if (!vis[i]) {
                dfs(vis, adj, i);

                edge /= 2;

                if (edge == (node * (node - 1) / 2)) {
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(boolean[] vis, List<List<Integer>> adj, int n) {
        vis[n] = true;
        node++;
        edge += adj.get(n).size();

        for (int next : adj.get(n)) {
            if (!vis[next]) {
                dfs(vis, adj, next);
            }
        }
    }
}