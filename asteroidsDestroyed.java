class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long curr = mass;
        for (int x : asteroids) {
            if (curr < x)
                return false;
            curr += x;
        }
        return true;
    }
}