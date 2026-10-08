import java.util.*;

class Solution {
    public String removeOuterParentheses(String s) {
        int i = 0;
        int open = 0, close = 0;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') open++;
            else if (s.charAt(j) == ')') close++;
            if (open == close) {
                sb.append(s.substring(i + 1, j));
                i = j + 1;
            }
        }
        return sb.toString();
    }
}