import java.util.*;

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            else if (!stack.isEmpty() && c == ')') {
                stack.pop();
            }
            else if (c == ')') {
                res++;
            }
        }

        return stack.size() + res;
    }
}