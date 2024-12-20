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
    public void reverseOdd(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) return;

        // Swap nodes' values at odd levels
        if (level % 2 != 0) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        
        // Recursive calls for the next level
        reverseOdd(left.left, right.right, level + 1);
        reverseOdd(left.right, right.left, level + 1);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        reverseOdd(root.left, root.right, 1);
        return root;
    }
}