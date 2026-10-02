import java.util.ArrayList;

class Solution {

    public void generateParathesisString(String res, int n, HashSet<String> allCombinations,int open, int close)
    {
        if(n==0)
        {
            if(open!=close)
                {
                    for(int i=close; i<open; i++)
                    {
                        res+=")";
                    }
                }

            allCombinations.add(res);
            return;
        }
        if(n>=1)
        {
            generateParathesisString(res+"(", n-1, allCombinations, open+1, close);
            if(close<open)
            {
                 generateParathesisString(res+")", n, allCombinations, open, close+1);
            }   
        }
    }
    public List<String> generateParenthesis(int n) {
        HashSet<String> allCombinations= new HashSet<>();
        generateParathesisString("",n,allCombinations, 0, 0);
        return new ArrayList<>(allCombinations);
    }
}