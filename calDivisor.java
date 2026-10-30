class Solution {
    public void calDivisor(int n, ArrayList<Integer> list){
        for(long i=1; i*i<=n; i++){
            if(n%i==0){
                list.add((int)i);

                if(n/i!=i){
                    list.add((int)(n/i));
                }
            }
        }
    }

    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> div=new ArrayList<>();

        calDivisor(n, div);
        Collections.sort(div);

        int sum=0;

        for(int p=0; p<div.size(); p++){
            int k=div.get(p);
            int lastSm=-1;
            int flag=0;

            for(int i=0; i<n; i=i+k){
                int smi=i;
                int last=i;

                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;

                for(int j=i; j<i+k; j++){
                    if(nums[j]<min){
                        min=nums[j];
                        smi=j;
                    }

                    if(nums[j]>max){
                        max=nums[j];
                        last=j;
                    }
                }

                int f=0;
                int dip=0;
                for(int j=i; j<i+k; j++){
                    int curr=nums[j];
                    int next=nums[((j+1)%k)+i];

                    if(curr>next){
                        dip++;
                    }
                }

                if(dip>1){
                    f=1;
                }

                if(f==1 || lastSm>nums[smi]){
                    flag=1;
                    break;
                }

                lastSm=nums[last];
            }

            if(flag==0){
                sum+=k;
            }
        }

        return sum;
    }
}