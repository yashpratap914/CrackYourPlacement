/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> res = new ArrayList<>(); //empty list
        if(root == null){
            return res;
        }
        Queue<Node> qu = new LinkedList<>(); 
        qu.offer(root); // add root element in queue
        while(!qu.isEmpty()){
            int size = qu.size();
            ArrayList<Integer> inres = new ArrayList<>();
            while(size>0){
                Node currnode = qu.poll(); //popped
                inres.add(currnode.val);  // inserted in list
                for(Node child : currnode.children){  // added its children in queue
                    if(child!=null){
                        qu.offer(child);
                    }
                }   
            size--;
            } 
            res.add(inres);
        }
        return res;    
    }
}