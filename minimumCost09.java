class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;
        int take = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (take == 2) {
                take = 0;
            } else {
                total += cost[i];
                take++;
            }
        }
        return total;
    }
}