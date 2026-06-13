class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int[] d = new int[26];
        for (int i = 0; i < 26; i++) {
            d[i] = weights[i];
        }
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            int add = 0;
            for (char x : word.toCharArray()) {
                add += d[x - 'a'];
            }
            int res = add % 26;
            ans.append((char)(96 + 26 - res));
        }
        return ans.toString();
    }
}