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

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int lvl = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c == '(' && lvl++ > 0) || (c == ')' && --lvl > 0)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}