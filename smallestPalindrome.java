class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char mid = '\0';

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);

            left.append(String.valueOf(c).repeat(count[i] / 2));

            if (count[i] % 2 == 1) {
                mid = c;
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        if (mid != '\0') {
            return left.toString() + mid + right;
        }

        return left.toString() + right;
    }
}