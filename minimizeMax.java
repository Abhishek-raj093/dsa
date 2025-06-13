class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums[n-1] - nums[0];

        int result = right;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPair(nums, p , mid)){
              result = mid;
              right = mid - 1;
            }
            else{
                left = mid + 1;

            }
        }
        return result;
    }
     private boolean isPair(int [] nums, int p , int maxDiff){
            int i = 0;
            int TotalPairsPossible = 0;
            while(i < nums.length - 1){
                if((nums[i+1] - nums[i]) <= maxDiff) {
                    TotalPairsPossible++;
                    i = i + 2;
                }
                else{
                    i++;
                }
                if(TotalPairsPossible >= p) return true;

            }
            return false;
        }
}