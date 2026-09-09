class Solution {
    private int findNod(long n){
        int nod = 0;
        while(n > 0){
            ++nod;
            n /= 10;
        }
        return nod;
    }
    public long countCommas(long n) {
        long res = 0 ;
        int nod = findNod(n);
        int noc = nod % 3 == 0 ? nod / 3 - 1 : nod / 3;
        if(nod < 4)return 0;
        while(noc >= 1){
            long rightBound = Math.min(n,(long)Math.pow(10,(noc+1)*3)-1);
            long leftBound = ((long)Math.pow(10,noc*3)) - 1;
            res += noc * (rightBound - leftBound);
            --noc;
        }
        return res;
    }
}