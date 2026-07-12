class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        int[] sortedArray = arr.clone();

        Arrays.sort(sortedArray);

        int rank = 1;

        for (int x : sortedArray) {
            if (!rankMap.containsKey(x)) {
                rankMap.put(x, rank);
                rank++;
            }
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}