class Solution {
    public int minMaxDifference(int num) {
        
        int firstdigit = -1, firstnonnine = -1;
        int remain = num;

        while(remain >0)
        {
            int d = remain % 10;
            if(d != 9)
                firstnonnine = d;

            firstdigit = d;
            remain = remain /10;
        }

        
        int max = 0,min = 0, mul = 1;

        remain = num;

        while(remain > 0)
        {
            int d = remain %10;

            if(d != firstdigit)
            {
                min = min + (d*mul);
            }
            if(d == firstnonnine)
            {
                d = 9;
            }
            max = max + (d * mul);

            mul = mul * 10;
            remain = remain /10;
          
        }

        return max-min;
    }
}