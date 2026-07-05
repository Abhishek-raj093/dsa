class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int row = grid.size();
        int col = grid.get(0).size();

        int[][] dist = new int[row][col];

        for (int[] arr : dist) {
            Arrays.fill(arr, -2);
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{0, 0});

        if (grid.get(0).get(0) == 1) {
            dist[0][0] = health - 1;
            if (dist[0][0] <= 0) 
                return false;
        } else {
            dist[0][0] = health;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int i = cur[0];
            int j = cur[1];

            if (i == row - 1 && j == col - 1)
                return true;

            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];

                if (x >= 0 && x < row && y >= 0 && y < col && dist[x][y] == -2) {
                    int cost = grid.get(x).get(y) == 1 ? 1 : 0;
                    int newHealth = dist[i][j] - cost;

                    if (newHealth > 0 && newHealth > dist[x][y]) {
                        dist[x][y] = newHealth;

                        if (cost == 0)
                            q.offerFirst(new int[]{x, y});
                        else
                            q.offerLast(new int[]{x, y});
                    }
                }
            }
        }

        return false;
    }
}