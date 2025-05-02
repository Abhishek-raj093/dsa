import java.util.*;

class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        int n = sb.length();
        int i = 0;

        int left = -1; // Last seen L
        int right = -1; // Last seen R

        while (i < n) {
            char c = sb.charAt(i);
            if (c == 'L') {
                if (right == -1) {
                    // Case: ...L
                    for (int k = left + 1; k < i; k++) {
                        sb.setCharAt(k, 'L');
                    }
                } else {
                    // Case: R...L
                    int low = right + 1, high = i - 1;
                    while (low < high) {
                        sb.setCharAt(low++, 'R');
                        sb.setCharAt(high--, 'L');
                    }
                    // Middle stays '.' if even gap
                }
                left = i;
                right = -1;
            } else if (c == 'R') {
                if (right != -1) {
                    // Case: R...R
                    for (int k = right + 1; k < i; k++) {
                        sb.setCharAt(k, 'R');
                    }
                }
                right = i;
            }
            i++;
        }

        // Handle trailing R... at end
        if (right != -1) {
            for (int k = right + 1; k < n; k++) {
                sb.setCharAt(k, 'R');
            }
        }

        return sb.toString();
    }
}