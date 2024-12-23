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
    class Pair {
        int ele;
        int idx;
        
        public Pair(int ele, int idx) {
            this.ele = ele;
            this.idx = idx;
        }
    }
    
    public void swap(ArrayList<Integer> arr, int idx1, int idx2) {
        int temp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, temp);
    }
    
    public int countMinSwap(ArrayList<Integer> arr) {
        int count = 0;
        ArrayList<Pair> arrWithIndex = new ArrayList<>();
        
        for (int i = 0; i < arr.size(); i++) {
            arrWithIndex.add(new Pair(arr.get(i), i));
        }
        
        arrWithIndex.sort((a, b) -> a.ele - b.ele);
        
        boolean[] visited = new boolean[arr.size()];
        
        for (int i = 0; i < arr.size(); i++) {
            if (visited[i] || arrWithIndex.get(i).idx == i) {
                continue;
            }
            
            int cycleSize = 0;
            int j = i;
            
            while (!visited[j]) {
                visited[j] = true;
                j = arrWithIndex.get(j).idx;
                cycleSize++;
            }
            
            if (cycleSize > 0) {
                count += (cycleSize - 1);
            }
        }
        
        return count;
    }
    
    public void levelOrderTraversal(Queue<TreeNode> q, ArrayList<ArrayList<Integer>> arr) {
        Queue<TreeNode> temp = new LinkedList<>();
        
        while (!q.isEmpty()) {
            ArrayList<Integer> sub = new ArrayList<>();
            
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                sub.add(node.val);
                
                if (node.left != null) {
                    temp.add(node.left);
                }
                
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            
            arr.add(sub);
            q.addAll(temp);
            temp.clear();
        }
    }
    
    public int minimumOperations(TreeNode root) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        levelOrderTraversal(q, arr);
        
        int ans = 0;
        for (ArrayList<Integer> level : arr) {
            ans += countMinSwap(level);
        }
        
        return ans;
    }
}