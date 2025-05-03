import java.util.*;

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Try tops[0] first
        int result = check(tops[0], tops, bottoms);
        // If tops[0] and bottoms[0] are the same, don't check again
        if (result != -1 || tops[0] == bottoms[0]) {
            return result;
        } else {
            // Try bottoms[0] if tops[0] failed
            return check(bottoms[0], tops, bottoms);
        }
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotateTop = 0;
        int rotateBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1; // Impossible to align with target
            } else if (tops[i] != target) {
                rotateTop++;
            } else if (bottoms[i] != target) {
                rotateBottom++;
            }
        }

        return Math.min(rotateTop, rotateBottom);
    }
}