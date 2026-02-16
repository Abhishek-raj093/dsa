import java.util.*;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] prev = new double[] { (double)poured };
        for (int i = 1; i <= query_row; i++) {
            double[] curr = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double extra = prev[j] - 1.0;
                if (extra > 0.0) {
                    curr[j] += extra * 0.5;
                    curr[j + 1] += extra * 0.5;
                }
            }
            prev = curr;
        }
        return Math.min(1.0, prev[query_glass]);
    }
}