class Solution {
  public int numberOfPairs(int[][] points) {
    // 1) sort by x asc; if x tie, y desc
    Arrays.sort(points, (a, b) -> {
      if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
      return -Integer.compare(a[1], b[1]);
    });
    int n = points.length, ans = 0;
    // 2) for each Alice=i, sweep to the right
    for (int i = 0; i < n; i++) {
      int yA = points[i][1];
      int maxY = Integer.MIN_VALUE; 
      for (int j = i + 1; j < n; j++) {
        int yB = points[j][1];
        if (yB <= yA && yB > maxY) {
          ans++;
          maxY = yB;
        }
      }
    }
    return ans;
  }
}