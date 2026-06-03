class Solution {
    public int earliestFinishTime1(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<landStartTime.length; i++){
            for(int j=0; j<waterStartTime.length; j++){
                int landFirst=landStartTime[i]+landDuration[i];
                int finishOne=Math.max(landFirst,waterStartTime[j])+waterDuration[j];

                int waterSecond=waterStartTime[j]+waterDuration[j];
                int finishTwo=Math.max(waterSecond,landStartTime[i])+landDuration[i];

                ans=Math.min(ans,finishOne);
                ans=Math.min(ans,finishTwo);
            }
        }
        return ans;
    }
}