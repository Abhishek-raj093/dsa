class Solution {
      static long[][][][][][]dp;
static String s;
    public long totalWaviness(long l, long r) {
          dp=new long[16][2][2][11][11][16];
           return solve(r) - solve(l - 1);
    }
    private static  long solve(long x){
	     if (x < 0) return 0;

        s = String.valueOf(x);
        	 for(long[][][][][]a:dp){
		     for(long[][][][]b:a){
		         for(long[][][]c:b){
		             for(long[][]d:c){
		                 for(long[]e:d){
		                     Arrays.fill(e,-1);
		                 }
		             }
		         }
		     }
		 }
       return digit(s,0,1,1,10,10,0);
	}
	 public static long digit(String s,int  pos,int tight,int lz,int prev,int prev2,int sum){
        
         if(pos==s.length()){
             return sum;
         }
         if(dp[pos][tight][lz][prev][prev2][sum]!=-1){
             return dp[pos][tight][lz][prev][prev2][sum];
         }
         int limit=(tight==1)?s.charAt(pos)-'0':9;
         long ans=0;
         for(int d=0;d<=limit;d++){
             int newtight=(tight==1&&d==limit)?1:0;
             int nlz = (lz == 1 && d == 0) ? 1 : 0;
         
         int nprev2=0;
         int nprev=0;
         int nsum=sum;
         if(nlz==1){
             nprev2=10;
             nprev=10;
             ans+=digit(s,pos+1,newtight,nlz,nprev,nprev2,sum);
         }
         else{
             if(prev2!=10){
                 if((prev>prev2&&prev>d)||(prev<prev2&&prev<d)){
                     nsum++;
                 }
             }
              nprev2=prev;
         nprev=d;
         ans+=digit(s,pos+1,newtight,nlz,nprev,nprev2,nsum);
         }
        
       
        
    }
     return dp[pos][tight][lz][prev][prev2][sum]=ans;
}
}