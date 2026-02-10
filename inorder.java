/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    // Inorder traversal to collect BST elements in sorted order
    private void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

    // Build a height-balanced BST from sorted list
    private TreeNode buildBST(int left, int right, List<Integer> nodes) {
        if (left > right) return null;

        int mid = (left + right) / 2; // choose middle element as root
        TreeNode root = new TreeNode(nodes.get(mid));

        // Recursively build left and right subtrees
        root.left = buildBST(left, mid - 1, nodes);
        root.right = buildBST(mid + 1, right, nodes);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        // Step 1: Store inorder traversal of BST
        inorder(root, nodes);

        // Step 2: Build balanced BST from sorted values
        return buildBST(0, nodes.size() - 1, nodes);
    }
}