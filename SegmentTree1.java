import java.util.*;

class Solution {
    static class SegmentTree {
        private static final int MAXK = 6;

        private final int k;
        private final int n;
        private final int[][] tree;

        SegmentTree(int[] nums, int k) {
            this.k = k;
            this.n = nums.length;

            int size = 4 * n + 5;
            tree = new int[size][MAXK];

            build(nums, 1, 0, n - 1);
        }

        private void makeLeaf(int node, int value) {
            Arrays.fill(tree[node], 0);

            int remainder = value % k;
            tree[node][remainder] = 1;
            tree[node][k] = remainder;
        }

        private void merge(int[] left, int[] right, int[] result) {
            int mulL = left[k];
            int mulR = right[k];

            Arrays.fill(result, 0);

            for (int x = 0; x < k; x++) {
                result[x] = left[x];
            }

            for (int x = 0; x < k; x++) {
                int remainder = (mulL * x) % k;
                result[remainder] += right[x];
            }

            result[k] = (mulL * mulR) % k;
        }

        private void maintain(int node) {
            merge(tree[node * 2], tree[node * 2 + 1], tree[node]);
        }

        private void build(int[] nums, int node, int left, int right) {
            if (left == right) {
                makeLeaf(node, nums[left]);
                return;
            }

            int mid = left + (right - left) / 2;

            build(nums, node * 2, left, mid);
            build(nums, node * 2 + 1, mid + 1, right);

            maintain(node);
        }

        void update(int node, int left, int right, int index, int value) {
            if (left == right) {
                makeLeaf(node, value);
                return;
            }

            int mid = left + (right - left) / 2;

            if (index <= mid) {
                update(node * 2, left, mid, index, value);
            } else {
                update(node * 2 + 1, mid + 1, right, index, value);
            }

            maintain(node);
        }

        int[] query(int node, int left, int right, int queryLeft, int queryRight) {
            if (queryLeft <= left && right <= queryRight) {
                return tree[node];
            }

            int mid = left + (right - left) / 2;

            if (queryRight <= mid) {
                return query(node * 2, left, mid, queryLeft, queryRight);
            }

            if (queryLeft > mid) {
                return query(node * 2 + 1, mid + 1, right, queryLeft, queryRight);
            }

            int[] leftResult = query(
                node * 2,
                left,
                mid,
                queryLeft,
                queryRight
            );

            int[] rightResult = query(
                node * 2 + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight
            );

            int[] result = new int[MAXK];
            merge(leftResult, rightResult, result);

            return result;
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;

        SegmentTree seg = new SegmentTree(nums, k);
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            seg.update(1, 0, n - 1, index, value);

            int[] result = seg.query(1, 0, n - 1, start, n - 1);
            answer[i] = result[x];
        }

        return answer;
    }
}