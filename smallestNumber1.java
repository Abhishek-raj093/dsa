class Solution {
    public int smallestNumber1(int n, int t) {

        while (n < 101) {
            int digits = n;
            int product = 1;

            while (digits > 0) {
                product *= digits % 10;
                digits /= 10;
            }

            if (product % t == 0)
                return n;

            n++;
        }

        return 0;
    }
}