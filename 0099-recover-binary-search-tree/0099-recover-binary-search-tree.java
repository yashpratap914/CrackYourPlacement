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
    TreeNode a;
    TreeNode b;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (root.val < prev.val && a == null) {
            a = prev;
            b = root;
        } else if (root.val < prev.val && a != null) {
            b = root;
        }
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}