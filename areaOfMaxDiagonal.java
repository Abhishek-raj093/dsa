class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxD = Math.sqrt(Math.pow(dimensions[0][0], 2) + Math.pow(dimensions[0][1], 2));
        int maxA = dimensions[0][0] * dimensions[0][1];

        for (int i = 1; i < dimensions.length; i++) {
            int l = dimensions[i][0];
            int b = dimensions[i][1];
            double d = Math.sqrt(l * l + b * b);
            int a = l * b;

            if (d > maxD) {
                maxD = d;
                maxA = a;
            } else if (Math.abs(d - maxD) < 1e-9) { 
                maxA = Math.max(maxA, a);
            }
        }
        return maxA;
    }
}
