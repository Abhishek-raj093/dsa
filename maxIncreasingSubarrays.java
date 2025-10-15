class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n < 2)
            return 0;
        int[] L = new int[n];
        int[] R = new int[n];
        Arrays.fill(L, 1);
        Arrays.fill(R, 1);
        for (int i = 1; i < n; i++){
            if (nums.get(i) > nums.get(i - 1)){
                L[i] = L[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--){
            if (nums.get(i) < nums.get(i + 1)){
                R[i] = R[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++){
            res = Math.max(res, Math.min(L[i], R[i + 1]));
        }
        return res;
    }
}