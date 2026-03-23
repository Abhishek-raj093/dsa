import java.util.*;

class Solution {
    public static long picker(int n, int m, long prod, int[][] grid){
        if(n==0 && m==0) return prod*grid[0][0]; 
        if(prod==0) return 0;
        
        long up = (n!=0) ? picker(n-1,m,prod*grid[n][m],grid) : Long.MIN_VALUE;
        long left = (m!=0) ? picker(n,m-1,prod*grid[n][m],grid) : Long.MIN_VALUE;

        return Math.max(up,left);
    }
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long ans = picker(n-1,m-1,1,grid);
        return ans<0 ? -1 : (int)(ans % 1000000007);
    }
}