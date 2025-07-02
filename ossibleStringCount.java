class Solution {
    private static final int mod = 1000000007;
    public int possibleStringCount(String word, int k) {
        int n = word.length(), cnt = 1;
        List<Integer> freq = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(word.charAt(i)==word.charAt(i-1)){
                cnt++;
            }
            else{
                freq.add(cnt);
                cnt=1;
            }
        }
        freq.add(cnt);
        long ans = 1;
        for(int f:freq){
            ans = (ans*f)%mod;
        }
        if(freq.size()>=k){
            return (int)ans;
        }
        int[] f = new int[k], g = new int[k];
        f[0] = 1;
        Arrays.fill(g,1);
        for(int i=0;i<freq.size();i++){
            int[] fNew = new int[k];
            for(int j=1;j<k;j++){
                fNew[j] = g[j-1];
                if(j-freq.get(i)-1>=0){
                    fNew[j] = (fNew[j]-g[j-freq.get(i)-1]+mod)%mod;
                }
            }
            int[] gNew = new int[k];
            gNew[0] = fNew[0];
            for(int j=1;j<k;j++){
                gNew[j] = (gNew[j-1]+fNew[j])%mod;
            }
            f=fNew;
            g=gNew;
        }
        return (int)((ans-g[k-1]+mod)%mod);
    }
}