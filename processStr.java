class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                ans.append(c);
            }
            else if (c == '*') { 
                if (ans.length() > 0) {
                    ans.deleteCharAt(ans.length() - 1);
                }
            }
            else if (c == '#') { 
                ans.append(ans.toString());
            }
            else { 
                ans.reverse();
            }
        }

        return ans.toString();
    }
}