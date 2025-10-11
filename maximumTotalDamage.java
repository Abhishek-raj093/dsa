class Solution {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        Arrays.sort(power);

        List<Integer> uniquePowers = new ArrayList<>();
        List<Long> totalDamages = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int currentPower = power[i];
            long sum = currentPower;
    
            while (i + 1 < n && power[i + 1] == currentPower) {
                i++;
                sum += currentPower;
            }
    
            uniquePowers.add(currentPower);
            totalDamages.add(sum);
        }

        long[] dp = new long[uniquePowers.size() + 1];

        for (int j = uniquePowers.size() - 1; j >= 0; j--) {
            long skip = dp[j + 1];
            long take = totalDamages.get(j);
    
            int nextIndex = j + 1;
            while (nextIndex < uniquePowers.size() && 
                uniquePowers.get(nextIndex) - uniquePowers.get(j) <= 2) {
                nextIndex++;
            }
            take += dp[nextIndex];
    
            dp[j] = Math.max(skip, take);
        }

        return dp[0];
    }
}     