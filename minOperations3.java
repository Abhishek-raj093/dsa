import java.util.*;

public class minOperations {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] mat = new int[m * n];
        int ans = 0;

        int k = 0;

        for (int[] j : grid)
            for (int i : j)
                mat[k++] = i;

        Arrays.sort(mat);

        k = mat[0];

        for (int i : mat)
            if ((i - k) % x != 0)
                return -1;

        int mid = mat[n * m / 2];

        for (int i : mat)
            ans += (Math.abs(i - mid) / x);

        return ans;
    }
}