class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int freq=map.containsKey(1)?map.get(1):0;
        int res=(freq!=0)&&(freq%2==0)?freq-1:freq;
        for(int n:map.keySet()){
            if(n==1)continue;
            int count=0;
            int num=n;
            while(map.containsKey(num)){
                if(map.get(num)>=2) count+=2;
                else {
                    count++;
                    break;
                }
                num=num*num;
            }
            if(count % 2 == 0) count--;
            res=Math.max(count,res);
        }
        return res;
    }
}