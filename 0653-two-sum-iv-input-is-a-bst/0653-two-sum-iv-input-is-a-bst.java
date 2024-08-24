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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> in = new ArrayList<>();
        inorder(root, in);
        int st =0;
        int end = in.size()-1;
        while(st<end){
            int sum= in.get(st)+in.get(end);
            if(sum == k){
                return true;
            }
            if(sum<k){
                st++;
            }else{
                end--;
            }
        }
        return false;
        
    }
    public void inorder(TreeNode root, ArrayList<Integer> in){
        if(root == null){
            return;
        }
        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }
}