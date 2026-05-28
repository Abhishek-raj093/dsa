class Solution {
    static class TrieNode {
        int idx;
        TrieNode[] children;

        TrieNode() {
            idx = -1;
            children = new TrieNode[26];

        }
    }

    public TrieNode getNode(int idx) {
        TrieNode t = new TrieNode();
        t.idx = idx;
        return t;
    }

    public void insert(TrieNode p, int i, String[] s) {
        String word = s[i];
        int n = word.length();

        for (int j = n -1; j >= 0; j--) {
            int cin = word.charAt(j) - 'a';

            if (p.children[cin] == null)
                p.children[cin] = getNode(i);
            
            p = p.children[cin];

            if (s[p.idx].length() > n)
                p.idx = i;
        }
    }

    public int search(TrieNode p, String s) {
        int r = p.idx;
        int n = s.length();

        for (int j = n - 1; j >= 0; j--) {
            int cin = s.charAt(j) - 'a';
            if (p.children[cin] == null)
                return r;
            p = p.children[cin];
            r = p.idx;
        } 
        return r;
    }
    public int[] stringIndices(String[] wc, String[] wq) {
        int l1 = wc.length;
        int l2 = wq.length;
        int[] ans = new int[l2];

        TrieNode root = getNode(0);

        for (int i = 0; i < l1; i++) {
            if (wc[root.idx].length() > wc[i].length())
                root.idx = i;
            insert(root, i, wc);
        }

        for (int i = 0; i < l2; i++)
            ans[i] = search(root, wq[i]);

        return ans;
    }
}