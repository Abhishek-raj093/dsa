class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        double totalRatio=0;
        for(int[] c:classes){
            int pass=c[0],total=c[1];
            double ratio=((double)pass/total);
            double improvement=((double)(pass+1)/(total+1)-ratio);
            totalRatio+=ratio;
            pq.offer(new double[]{improvement,pass,total});
        }
        while(extraStudents>0){
            double[] top=pq.poll();
            double improvement=top[0];
            int pass=(int)top[1];
            int total=(int)top[2];
            totalRatio-=((double)pass/total);
            pass++;
            total++;
            totalRatio+=((double)pass/total);
            double reimprovement=((double)(pass+1)/(total+1))-((double)pass/total);
            pq.offer(new double[]{reimprovement,pass,total});
            extraStudents--;
        }
        return totalRatio/classes.length;
    }
}