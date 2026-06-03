class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
                                    
        int minLengthLand = Integer.MAX_VALUE;
        int minTotalLand = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            minLengthLand = Math.min(
                minLengthLand,
                landStartTime[i] + landDuration[i]
            );
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            int start = Math.max(waterStartTime[i], minLengthLand);
            minTotalLand = Math.min(
                minTotalLand,
                start + waterDuration[i]
            );
        }

        int minLengthWater = Integer.MAX_VALUE;
        int minTotalWater = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            minLengthWater = Math.min(
                minLengthWater,
                waterStartTime[i] + waterDuration[i]
            );
        }

        for (int i = 0; i < landStartTime.length; i++) {
            int start = Math.max(landStartTime[i], minLengthWater);
            minTotalWater = Math.min(
                minTotalWater,
                start + landDuration[i]
            );
        }
        return Math.min(minTotalLand, minTotalWater);
    }
}