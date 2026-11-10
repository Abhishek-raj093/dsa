public class Solution {

    static int n;
    static ArrayList<Integer>[] a;
    static int[] p, d, h, t, o, z;
    static int[] s;
    static int c;
    static int[] g;

    public List<Boolean> palindromePath(int N, int[][] e, String str, String[] q) {

        n = N;
        int[][] xy = e;

        a = new ArrayList[n];
        int i = 0;
        while (i < n) {
            a[i] = new ArrayList<>();
            i++;
        }

        i = 0;
        while (i < xy.length) {
            a[xy[i][0]].add(xy[i][1]);
            a[xy[i][1]].add(xy[i][0]);
            i++;
        }

        p = new int[n];
        d = new int[n];
        h = new int[n];
        t = new int[n];
        o = new int[n];
        z = new int[n];

        Arrays.fill(h, -1);

        f(0, -1);

        c = 0;
        u(0, 0);

        s = new int[n];
        i = 0;
        while (i < n) {
            s[o[i]] = 1 << (str.charAt(i) - 'a');
            i++;
        }

        g = new int[4 * n];
        b(1, 0, n - 1);

        List<Boolean> r = new ArrayList<>();

        i = 0;
        while (i < q.length) {
            String[] x = q[i].split(" ");
            if (x[0].equals("update")) {
                int v = Integer.parseInt(x[1]);
                int m = 1 << (x[2].charAt(0) - 'a');
                w(1, 0, n - 1, o[v], m);
            } else {
                int v = Integer.parseInt(x[1]);
                int j = Integer.parseInt(x[2]);
                int m = y(v, j);
                r.add((m & (m - 1)) == 0);
            }
            i++;
        }

        return r;
    }

    static void f(int v, int par) {
        p[v] = par;
        z[v] = 1;
        int m = 0;
        int i = 0;

        while (i < a[v].size()) {
            int j = a[v].get(i);
            if (j != par) {
                d[j] = d[v] + 1;
                f(j, v);
                z[v] += z[j];
                if (z[j] > m) {
                    m = z[j];
                    h[v] = j;
                }
            }
            i++;
        }
    }

    static void u(int v, int k) {
        t[v] = k;
        o[v] = c++;
        if (h[v] != -1)
            u(h[v], k);

        int i = 0;
        while (i < a[v].size()) {
            int j = a[v].get(i);
            if (j != p[v] && j != h[v])
                u(j, j);
            i++;
        }
    }

    static void b(int v, int l, int r) {
        if (l == r) {
            g[v] = s[l];
            return;
        }
        int m = (l + r) >> 1;
        b(v << 1, l, m);
        b(v << 1 | 1, m + 1, r);
        g[v] = g[v << 1] ^ g[v << 1 | 1];
    }

    static void w(int v, int l, int r, int i, int val) {
        if (l == r) {
            g[v] = val;
            return;
        }
        int m = (l + r) >> 1;
        if (i <= m)
            w(v << 1, l, m, i, val);
        else
            w(v << 1 | 1, m + 1, r, i, val);
        g[v] = g[v << 1] ^ g[v << 1 | 1];
    }

    static int x(int v, int l, int r, int ql, int qr) {
        if (ql > r || qr < l)
            return 0;
        if (ql <= l && r <= qr)
            return g[v];
        int m = (l + r) >> 1;
        return x(v << 1, l, m, ql, qr) ^ x(v << 1 | 1, m + 1, r, ql, qr);
    }

    static int y(int v, int j) {
        int r = 0;
        for (; t[v] != t[j];) {
            if (d[t[v]] < d[t[j]]) {
                int tmp = v;
                v = j;
                j = tmp;
            }
            r ^= x(1, 0, n - 1, o[t[v]], o[v]);
            v = p[t[v]];
        }
        if (d[v] > d[j]) {
            int tmp = v;
            v = j;
            j = tmp;
        }
        r ^= x(1, 0, n - 1, o[v], o[j]);
        return r;
    }
}