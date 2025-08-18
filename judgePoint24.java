import java.util.*;

class Solution {
    private static final double EPS = 1e-6;

    public boolean judgePoint24(int[] cards) {
        double[] arr = new double[]{cards[0], cards[1], cards[2], cards[3]};
        return judge(arr);
    }

    private boolean judge(double[] cards) {
        int n = cards.length;
        if (n == 1) return Math.abs(cards[0] - 24) < EPS;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double[] next = new double[n - 1];
                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) next[idx++] = cards[k];
                }
                for (double val : compute(cards[i], cards[j])) {
                    next[next.length - 1] = val;
                    if (judge(next)) return true;
                }
            }
        }
        return false;
    }

    private double[] compute(double x, double y) {
        List<Double> res = new ArrayList<>();
        res.add(x + y);
        res.add(x - y);
        res.add(y - x);
        res.add(x * y);
        if (Math.abs(y) > EPS) res.add(x / y);
        if (Math.abs(x) > EPS) res.add(y / x);
        double[] out = new double[res.size()];
        for (int i = 0; i < res.size(); i++) out[i] = res.get(i);
        return out;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cards = new int[4];
        for (int i = 0; i < 4; i++) {
            if (!sc.hasNextInt()) {
                System.out.println("Please enter 4 integers.");
                sc.close();
                return;
            }
            cards[i] = sc.nextInt();
        }
        boolean ans = new Solution().judgePoint24(cards);
        System.out.println(ans);
        sc.close();
    }
}
