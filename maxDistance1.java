import java.util.*;

class Solution {
    static public int maxDistance1(int[] colors) {
        final int n=colors.length;
        final int c0=colors[0], cN=colors[n-1];
        int lMax=0, rMax=0;
        for(int i=0; i<n; i++){
            final int c=colors[i];
            if (c0!=c && i>lMax) lMax=i;
            if (cN!=c && n-1-i>rMax) rMax=n-1-i;
        }
        return Math.max(lMax, rMax);
    }
}