class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;

        int maxAltitude = 0;

        for (int change : gain) {
            currentAltitude += change;

            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
}