import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
            return 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    dist[r][c] = 0;
                    q.offer(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == Integer.MAX_VALUE) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        boolean[][] seen = new boolean[n][n];

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        heap.offer(new int[]{dist[0][0], 0, 0});

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int safe = cur[0], r = cur[1], c = cur[2];

            if (seen[r][c])
                continue;

            seen[r][c] = true;

            if (r == n - 1 && c == n - 1)
                return safe;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !seen[nr][nc]) {
                    int newSafe = Math.min(safe, dist[nr][nc]);
                    heap.offer(new int[]{newSafe, nr, nc});
                }
            }
        }

        return -1;
    }
}