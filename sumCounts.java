class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size(),res=0;
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                int size=set.size();
                res+=size*size;
            }
            set.clear();
        }
        return res;
    }
}