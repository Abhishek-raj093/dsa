import java.util.*;

class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean rslt = true;
        int prev = -1, rem = 0;
        while (n > 0){
            if (prev == -1){
                prev = n % 2;
            } else {
                rem = n % 2;
                if (rem == prev){
                    return false;
                }
                prev = rem;
            }
            n = n >> 1;
            //System.out.println("prev = " + prev + " rem = " + rem + " n = " + n);
        }

        return rslt;
    }
}