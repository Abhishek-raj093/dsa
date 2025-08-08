class Solution {
    private double[][] dp; 

    public double soupServings(int n) {
        if (n > 4800) return 1.0; 

        int scaledN = (int) Math.ceil(n / 25.0); 
        dp = new double[scaledN + 1][scaledN + 1]; 
        return serve(scaledN, scaledN); 
    }

    private double serve(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5; 
        
        if (a <= 0) {
            return 1.0; 
        }
        if (b <= 0) {
            return 0.0; 
        }

        if (dp[a][b] != 0) { 
            return dp[a][b];
        }
        dp[a][b] = 0.25 * (
            serve(a - 4, b) +  
            serve(a - 3, b - 1) + 
            serve(a - 2, b - 2) + 
            serve(a - 1, b - 3)      
        );

        return dp[a][b]; 
    }
}