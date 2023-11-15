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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, curr = head;
        while(curr != null) {
            ListNode nxt = curr.next;
            
            if(curr.val == val)
                prev.next = nxt;
            else
                prev = curr;
            
            curr = nxt;
        }
        return dummy.next;
        
    }
}