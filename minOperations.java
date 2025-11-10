class Solution {
  int minOperations(List<int> nums) {
    List<int> stack = List.filled(nums.length + 1, 0);
    int top = 0;
    int ans = 0;

    for (int i = 0; i < nums.length; i++) {
      while (stack[top] > nums[i]) {
        top--;
        ans++;
      }
      if (stack[top] != nums[i]) {
        top++;
        stack[top] = nums[i];
      }
    }

    return ans + top;
  }
}