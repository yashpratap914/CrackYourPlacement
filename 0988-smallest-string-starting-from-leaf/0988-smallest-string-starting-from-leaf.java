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
    String smallestString;

    void dfs(TreeNode node, StringBuilder s) {
        if (node == null) return;

        s.append((char) ('a' + node.val));
        if (node.left == null && node.right == null) {
            // Reverse the string
            s.reverse();

            if (smallestString.isEmpty()) {
                smallestString = s.toString();
            } else {
                smallestString = min(smallestString, s.toString());
            }

            // Reverse the string back
            s.reverse();
        }

        dfs(node.left, s);
        dfs(node.right, s);

        // Remove the last character
        s.deleteCharAt(s.length() - 1);
    }

    public String smallestFromLeaf(TreeNode root) {
        smallestString = "";
        StringBuilder s = new StringBuilder();
        dfs(root, s);

        return smallestString;
    }
    
    private String min(String a, String b) {
        return a.compareTo(b) <= 0 ? a : b;
    }
}