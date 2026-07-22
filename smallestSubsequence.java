class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        Stack<Character> st=new Stack<>();
        boolean vis[]=new boolean[26];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(vis[ch-'a']) continue;
            while(st.size()>0 && st.peek()>ch && i<map.get(st.peek())){
                char c=st.pop();
                vis[c-'a']=false;
            }
            st.push(ch);
            vis[ch-'a']=true;
        }
        String ans="";
        while(!st.isEmpty()){
            ans=st.pop()+ans;
        }
        return ans;

    }
}