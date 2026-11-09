class Solution {
    int[][] visited;

    private long dfs(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        if (visited[i][j] == 1 || grid[i][j] == 0) {
            return 0;
        }

        visited[i][j] = 1;

        return grid[i][j]
                + dfs(grid, m, n, i + 1, j)
                + dfs(grid, m, n, i - 1, j)
                + dfs(grid, m, n, i, j + 1)
                + dfs(grid, m, n, i, j - 1);
    }

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 1 || grid[i][j] == 0) {
                    continue;
                }

                cnt += dfs(grid, m, n, i, j) % k == 0 ? 1 : 0;
            }
        }

        return cnt;
    }
}