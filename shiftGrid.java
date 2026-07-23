import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int newJ = (j + k) % m;
                int newI = (i + (j + k) / m) % n;

                res[newI][newJ] = grid[i][j];
            }
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (int[] row : res) {
            List<Integer> currentRow = new ArrayList<>();

            for (int value : row) {
                currentRow.add(value);
            }

            answer.add(currentRow);
        }

        return answer;
    }
}