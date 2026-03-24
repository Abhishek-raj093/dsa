import java.util.Arrays;

public class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int mod = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int[][] Ans = new int[n][m];

        // Initialize the result matrix elements to 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Ans[i][j] = 1;
            }
        }

        long Mul = 1; // Initialize a variable to keep track of the cumulative product.

        // Calculate the product of elements in the forward direction (left to right, top to bottom).
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Ans[i][j] = (int) (Ans[i][j] * Mul % mod); // Multiply the element with the cumulative product and apply modulo.
                Mul = Mul * grid[i][j] % mod; // Update the cumulative product.
            }
        }

        Mul = 1; // Reset the cumulative product to 1.

        // Calculate the product of elements in the reverse direction (right to left, bottom to top).
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                Ans[i][j] = (int) (Ans[i][j] * Mul % mod); // Multiply the element with the cumulative product and apply modulo.
                Mul = Mul * grid[i][j] % mod; // Update the cumulative product.
            }
        }

        return Ans; // Return the product matrix.
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] result = solution.constructProductMatrix(grid);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}