class Solution {
    public class HNode {
        int start;
        int end;
        int val;
        public HNode(int start, int end, int val) {
            this.start = start;
            this.val = val;
            this.end = end;
        }
    }

    public class Pair {
        int max;
        int min;
        public Pair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    public class Node {
        Node right;
        Node left;
        int max;
        int min;
        int start;
        int end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public class STree {
        Node root;
        public STree(int[] arr) {
            this.root = createTree(arr, 0, arr.length - 1);
        }

        public Node createTree(int[] arr, int start, int end) {
            if (start == end) {
                Node leaf = new Node(start, start);
                leaf.max = arr[start];
                leaf.min = arr[end];
                return leaf;
            }
            int mid = start + (end - start) / 2;
            Node n = new Node(start, end);
            n.left = createTree(arr, start, mid);
            n.right = createTree(arr, mid + 1, end);
            n.max = Math.max(n.left.max, n.right.max);
            n.min = Math.min(n.left.min, n.right.min);
            return n;
        }

        public Pair query(int left, int right) {
            return helper(left, right, this.root);
        }

        private Pair helper(int left, int right, Node root) {
            int node_s = root.start;
            int node_e = root.end;
            if (node_e <= right && node_s >= left) {
                return new Pair(root.max, root.min);
            }
            if (right < node_s || left > node_e) {
                return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
            } else {
                Pair left_a = helper(left, right, root.left);
                Pair right_a = helper(left, right, root.right);
                return new Pair(Math.max(left_a.max, right_a.max), Math.min(right_a.min, left_a.min));
            }
        }
    }

    public long maxTotalValue(int[] arr, int k) {
        int n = arr.length;
        STree tree = new STree(arr);
        PriorityQueue<HNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val));
        
        for (int i = 0; i < n; i++) {
            int end = n - 1;
            Pair curr = tree.query(i, end);
            int c_val = curr.max - curr.min;
            pq.offer(new HNode(i, end, c_val));
        }
        
        long ans = 0;
        
        while (k > 0) {
            HNode node = pq.poll();
            ans = ans + node.val;
            int curr_s = node.start;
            int next_e = node.end - 1;
            
            if (curr_s <= next_e) {
                Pair next_range = tree.query(curr_s, next_e);
                int n_val = next_range.max - next_range.min;
                pq.offer(new HNode(curr_s, next_e, n_val));
            }
            k--;
        }

        return ans;
    }
}