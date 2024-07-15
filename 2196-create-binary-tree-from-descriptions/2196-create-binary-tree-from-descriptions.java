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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Map<Integer, Boolean> hasParent = new HashMap<>();

        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));

            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            hasParent.put(childVal, true);
            nodeMap.put(childVal, childNode);
            nodeMap.put(parentVal, parentNode);
        }

        TreeNode rootNode = null;
        for (Map.Entry<Integer, TreeNode> entry : nodeMap.entrySet()) {
            if (!hasParent.getOrDefault(entry.getKey(), false)) {
                rootNode = entry.getValue();
                break;
            }
        }

        return rootNode;
        
    }
}