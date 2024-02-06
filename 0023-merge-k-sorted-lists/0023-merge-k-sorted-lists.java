/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a min heap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the first node from each linked list to the min heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        
        // Create a dummy node to build the result linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Remove the minimum element from the min heap and add it to the result linked list
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            
            // Add the next node from the same linked list to the min heap if it exists
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        
        return dummy.next;
        
    }
}