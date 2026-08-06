class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] d = new int[n];
        for (int[] i : invocations) {
            d[i[0]]++;
        }

        int[][] e = new int[n][];
        for (int i = 0; i < n; i++) {
            e[i] = new int[d[i]];
        }

        for (int[] i : invocations) {
            int u = i[0];
            e[u][--d[u]] = i[1];
        }
        
        boolean[] sus = new boolean[n];
        sus[k] = true;

        int[] q = new int[n];
        int front = 0, back = 1;
        q[0] = k;

        while (front < back) {
            int u = q[front++];

            for (int v : e[u]) {
                if (!sus[v]) {
                    q[back++] = v;
                    sus[v] = true;
                }
            }
        }

        for (int[] i : invocations) {
            int u = i[0], v = i[1];
            if (!sus[u] && sus[v]) {
                ArrayList<Integer> ret = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    ret.add(j);
                }
                return ret;
            }
        }

        ArrayList<Integer> ret = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (!sus[i]) {
                ret.add(i);
            }
        }

        return ret;
    }
}