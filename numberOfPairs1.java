class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int counter = 0;
        for (int i = 0; i < points.length; i++) {
            int x0 = points[i][0], y0 = points[i][1];
            int bottom = Integer.MIN_VALUE;
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[j][0], y1 = points[j][1];
                if (bottom < y1 && y1 <= y0) {
                    bottom = y1;
                    counter++;
                    if (y1 == y0) {
                        break;
                    }
                }
            }
        }
        return counter;
    }
}