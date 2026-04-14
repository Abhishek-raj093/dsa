import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b)->{
           return a[0]-b[0];
        });

        List<Integer>list = new ArrayList<>();

        for(int i=0;i<factory.length;i++){
            for(int j=0;j<factory[i][1];j++){
                list.add(factory[i][0]);
            }
        }

        dp = new long[robot.size()+1][list.size()];
        for(long i[] : dp){
            Arrays.fill(i,-1);
        }

        return helper(0,0,robot,list);
    }

    long dp[][];
    public long helper(int i, int j, List<Integer>rob, List<Integer>fac){
        if(i>=rob.size()){
            return 0;
        }

        if(j>=fac.size()){
            return Long.MAX_VALUE/2;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        // leave
        long opt1 = helper(i, j+1, rob, fac);
        // take
        long opt2 = Math.abs(rob.get(i)-fac.get(j)) + helper(i+1, j+1, rob, fac);

        return dp[i][j]=Math.min(opt1, opt2);
    }
}