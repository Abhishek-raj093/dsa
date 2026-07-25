class Solution {
    static void fwht(long[] a,boolean inv){
        int n=a.length;
        for(int len=1;len<n;len<<=1){
            for(int i=0;i<n;i+=len<<1){
                for(int j=0;j<len;j++){
                    long u=a[i+j];
                    long v=a[i+j+len];
                    a[i+j]=u+v;
                    a[i+j+len]=u-v;
                }
            }
        }

        if(inv){
            for(int i=0;i<n;i++)a[i]/=n;
        }
    }

    public int uniqueXorTriplets(int[] nums){
        int N=2048;
        long[] f=new long[N];

        for(int x:nums)f[x]=1;

        fwht(f,false);

        for(int i=0;i<N;i++)
            f[i]=f[i]*f[i]*f[i];

        fwht(f,true);

        int ans=0;
        for(int i=0;i<N;i++)
            if(f[i]!=0)ans++;

        return ans;
    }
}