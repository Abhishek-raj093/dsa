class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long ans = 0L;
        int maxx = 0;
        int ops = k1+k2;
        for(int i=0;i<nums1.length;i++)
            maxx = Math.max(maxx, Math.abs(nums1[i]-nums2[i]));
        int[] freq = new int[maxx+1];
        for(int i=0;i<nums1.length;i++)
            freq[Math.abs(nums1[i]-nums2[i])]++;
        for(int i=maxx;i>=1 && ops>0;i--) {
            int minn = Math.min(ops,freq[i]);
            ops -= minn;
            freq[i] -= minn;
            freq[i-1] += minn;
        }
        for(int i=maxx;i>=1;i--)
        ans += ((long)i*i*freq[i]);
        return ans;
    }
}