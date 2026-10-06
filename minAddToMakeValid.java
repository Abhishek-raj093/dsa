class Solution {
    public int minAddToMakeValid(String s) {
        int counter=0;
        Stack<Character>stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(')stack.push(c);
            else{
                if(stack.isEmpty())counter++;
                else{
                    if(stack.peek()!='(')counter++;
                    else stack.pop();
                }
            }
        }
        return counter+stack.size();
    }
}