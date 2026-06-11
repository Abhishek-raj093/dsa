class Solution {

    int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] e : edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());

            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        // DFS from node 1 to find max depth
        dfs(1, -1, 0, map);

        int exp = maxDepth - 1;

        long ans = 1;
        long base = 2;
        long mod = 1_000_000_007;

        // simple power calculation - Math.pow increases tle 
        for (int i = 0; i < exp; i++) {
            ans = (ans * base) % mod;
        }

        return (int) ans;
    }


    void dfs(int node, int parent, int depth, HashMap<Integer, List<Integer>> map) {

        maxDepth = Math.max(maxDepth, depth);

        for (int ele : map.getOrDefault(node, new ArrayList<>())) {
            if (ele != parent) {
                dfs(ele, node, depth + 1, map);
            }
        }
    }
}