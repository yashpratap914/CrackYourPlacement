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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false;

        while(!q.isEmpty()){
            int levelsize = q.size();
            ArrayList<Integer> currlvl = new ArrayList<>(levelsize);
            for(int i =0; i<levelsize; i++){
                
                if(!reverse){
                    TreeNode currnode = q.pollFirst();
                    currlvl.add(currnode.val);
                    if(currnode.left != null){
                        q.addLast(currnode.left);
                    }
                    if(currnode.right != null){
                        q.addLast(currnode.right);
                    }   
                }else{
                    TreeNode currnode = q.pollLast();
                    currlvl.add(currnode.val);
                    if(currnode.right != null){
                        q.addFirst(currnode.right);
                    }  
                    if(currnode.left != null){
                        q.addFirst(currnode.left);
                    }
                }
            }
            reverse = !reverse;
            res.add(currlvl);
        }
        return res;
        
    }
}