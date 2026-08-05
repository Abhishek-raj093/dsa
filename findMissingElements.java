class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        boolean[] present = new boolean[101];

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for (int num : nums) {
            present[num] = true;
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = mini; i <= maxi; i++) {
            if (!present[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}