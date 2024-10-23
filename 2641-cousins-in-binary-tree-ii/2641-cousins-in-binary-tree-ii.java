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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        // List to store the Each Level sum 
        ArrayList<Integer> ls = new ArrayList<Integer>();
        // Compute the sum for every level
        while(!q.isEmpty())
        {
            int s =0;
            Queue<TreeNode> a = new LinkedList<TreeNode>();
            while(!q.isEmpty())
            {
                TreeNode t = q.remove();
                if(t.left!=null) a.add(t.left);
                if(t.right!=null) a.add(t.right);
                s+=t.val;
            }
            q=a;
            ls.add(s);
        }
        q.add(root);
        // Root val is always be Zero since it does not have any cousins node of its own
        root.val=0;
        int i=1;
        // Replace the each node values with the cousins node
        while(!q.isEmpty())
        {
            Queue<TreeNode> a = new LinkedList<TreeNode>();
            while(!q.isEmpty())
            {
                int ss = 0;
                TreeNode t = q.remove();
                if(t.left!=null) ss+=t.left.val;
                if(t.right!=null) ss+=t.right.val;
                if(t.left!=null)
                {
                    t.left.val = ls.get(i)-ss;
                    a.add(t.left);
                }
                if(t.right!=null)
                {
                    t.right.val = ls.get(i)-ss;
                    a.add(t.right);
                }
            }
            q=a;i++;
        }
        // Return the root node as result
        return root;
    }
}