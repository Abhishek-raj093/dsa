class Solution {
    public boolean isPowerOfTwo(int a) {
        return a > 0 && (a & (a - 1)) == 0;
    }
}