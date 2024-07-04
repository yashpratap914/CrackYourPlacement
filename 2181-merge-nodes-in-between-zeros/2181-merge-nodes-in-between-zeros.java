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
    public ListNode mergeNodes(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode temp = head.next;
        int sum =0;
        while(temp!=null){
            if(temp.val!=0){
                sum+=temp.val;
            }
            else{
                ListNode newNode = new ListNode(sum);
                sum=0;
                if(newHead == null) newHead = newNode;
                else{
                    newTail.next = newNode;
                }
                newTail = newNode;
            }
            temp = temp.next;
        }
        return newHead;
        
    }
}