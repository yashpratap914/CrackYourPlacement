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
    public static int heightoftree(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftheight = heightoftree(root.left);
        int rightheight= heightoftree(root.right);
        int myheight = Math.max(leftheight, rightheight)+1;
        return myheight;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int dia1 = diameterOfBinaryTree(root.left);
        int dia2 = diameterOfBinaryTree(root.right);
        int dia3 = heightoftree(root.left)+heightoftree(root.right);

        return Math.max(dia3, Math.max(dia1, dia2));
        
    }
}