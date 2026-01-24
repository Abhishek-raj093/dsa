class Solution {
    public int minPairSum(int[] numbers) {
        // Sort the array to pair smallest with largest
        Arrays.sort(numbers);

        int start = 0, end = numbers.length - 1;
        int maxPair = 0;

        // Pair elements from both ends
        while (start < end) {
            int pairSum = numbers[start] + numbers[end];
            if (pairSum > maxPair) {
                maxPair = pairSum;
            }
            start++;
            end--;
        }

        return maxPair;
    }
}