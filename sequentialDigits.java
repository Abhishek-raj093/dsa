class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> res = new ArrayList<>();

        int n = String.valueOf(low).length();
        int m = String.valueOf(high).length();

        for (int length = n; length <= m; length++) {
            for (int i = 0; i < 10 - length; i++) {
                int num = Integer.parseInt(
                    digits.substring(i, i + length)
                );

                if (low <= num && num <= high) {
                    res.add(num);
                }
            }
        }

        return res;
    }
}