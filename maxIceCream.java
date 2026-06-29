import java.util.*;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;

        for (int cost : costs) {
            max = Math.max(max, cost);
        }

        int[] freq = new int[max + 1];

        for (int cost : costs) {
            freq[cost]++;
        }

        int ans = 0;

        for (int cost = 1; cost < freq.length && cost <= coins; cost++) {
            int buy = Math.min(freq[cost], coins / cost);

            coins -= cost * buy;
            ans += buy;
        }

        return ans;
    }
}