import java.util.Stack;
import java.util.*;

class Solution {
    public String reverseParentheses(String s) {

        Stack<StringBuilder> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.add(sb);
                sb = new StringBuilder();
                continue;
            }

            if (c == ')') {
                sb.reverse();
                if (!st.isEmpty()) {
                    StringBuilder top = st.pop();
                    top.append(sb.toString());
                    sb = top;
                }
                continue;
            }

            sb.append(c);
        }

        return sb.toString();
    }
}