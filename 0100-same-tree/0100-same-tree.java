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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case 
    if(p==null && q==null){
        return true;
    }
    if(p==null && q!=null){
        return false;
    }
    if(p!=null && q==null){
        return false;
    }
    
    // recursive call for both  tree
    boolean left=isSameTree(p.left,q.left);
    boolean right=isSameTree(p.right, q.right);
    
    // check values for both root samme or not
    boolean check = p.val==q.val;
    
    // check and return
    if(left && right && check){
        return true;
    }
    else{
        return false;
    }
    }
}