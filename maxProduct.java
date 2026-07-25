class Solution {
    public int maxProduct(int n) {
        int max = n % 10;
        int secmax = -1;
        n /= 10;
        
        while(n > 0) {
            int digit = n % 10;
            if(digit < max) {
                secmax = Math.max(secmax, digit);
            }else if(digit == max) {
                secmax = max;

            }else {
                secmax = max;
                max = digit;
            }
            n /= 10;
        }
        return max * secmax;
    }
}