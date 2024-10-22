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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;  
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> levelSums = new ArrayList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long currentLevelSum = 0;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelSum += currentNode.val;
                
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            levelSums.add(currentLevelSum);
        }
        Collections.sort(levelSums, Collections.reverseOrder());

        if (k > levelSums.size()) {
            return -1;
        }
        return levelSums.get(k - 1);
        
    }
}