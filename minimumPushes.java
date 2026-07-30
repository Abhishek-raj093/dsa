class Solution {
    public int minimumPushes(String word) {
        // so whaever appears max no of times for first 8 assign them 1 -> next 8 assign them 2 -> next left assign them 3. 
        Integer[] f = new Integer[26]; 
        Arrays.fill(f, 0); 
        for(int i = 0; i < word.length(); i++) f[word.charAt(i) - 'a']++; 
        Arrays.sort(f, Collections.reverseOrder()); 
        int ans = 0; 
        for(int i = 0; i < 26; i++) {
            if(f[i] != 0) {
                ans += (i / 8 + 1) * f[i]; 
            }
        }
        return ans; 
    }
}