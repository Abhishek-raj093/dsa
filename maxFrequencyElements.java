class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int maxFreq = Collections.max(freq.values());
        int total = 0;
        for (int count : freq.values()) {
            if (count == maxFreq) total += count;
        }
        return total;
    }
}