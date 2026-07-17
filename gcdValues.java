class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxValue = 0;

        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        int[] freq = new int[maxValue + 1];

        for (int num : nums) {
            freq[num]++;
        }

        long[] count = new long[maxValue + 1];

        for (int gcdValue = maxValue; gcdValue >= 1; gcdValue--) {
            long total = 0;

            for (
                int multiple = gcdValue;
                multiple <= maxValue;
                multiple += gcdValue
            ) {
                total += freq[multiple];
            }

            long pairs = total * (total - 1) / 2;

            for (
                int multiple = 2 * gcdValue;
                multiple <= maxValue;
                multiple += gcdValue
            ) {
                pairs -= count[multiple];
            }

            count[gcdValue] = pairs;
        }

        List<Long> prefix = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        long sum = 0;

        for (int gcdValue = 1; gcdValue <= maxValue; gcdValue++) {
            if (count[gcdValue] > 0) {
                sum += count[gcdValue];
                prefix.add(sum);
                values.add(gcdValue);
            }
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;

            int left = 0;
            int right = prefix.size();

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            result[i] = values.get(left);
        }

        return result;
    }
}