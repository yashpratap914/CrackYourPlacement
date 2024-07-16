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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Get paths from root to start value and root to dest value
        StringBuilder startPath = getPath(root, startValue);
        StringBuilder destPath = getPath(root, destValue);

		// Remove the common prefix
        int len = Math.min(startPath.length(), destPath.length());
        int i = 0;
        while (i < len && startPath.charAt(startPath.length() - i - 1) == destPath.charAt(destPath.length() - i - 1))
            i += 1;

		// Replace remaining left path with 'U' chars and concat startPath and destPath
        return "U".repeat(startPath.length() - i) + destPath.reverse().substring(i);
    }

    private StringBuilder getPath(TreeNode root, int target) {

        if (root == null) return null;

        if (root.val == target) return new StringBuilder();

        StringBuilder left = getPath(root.left, target);
        if (left != null) {
            left.append("L");
            return left;
        }

        StringBuilder right = getPath(root.right, target);
        if (right != null) {
            right.append("R");
            return right;
        }
        return null;
        
    }
}