class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        int count_one = 0;
        int count_zro = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                count_zro++;
            } else {
                count_one++;
                if (count_zro != 0) {
                    list.add(count_zro);
                }
                count_zro = 0;
            }
        }
        if (count_zro != 0) {
            list.add(count_zro);
        }

        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            max = Math.max(max, list.get(i) + list.get(i + 1));
        }

        return count_one + max;

    }
}