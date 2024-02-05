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
    public ListNode swapPairs(ListNode head) {
        // Base case: less than two nodes left
        if (head == null || head.next == null) {
            return head;
        }
        
        // Swap the first two nodes
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        
        return newHead;
        
    }
}