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
    public ListNode partition(ListNode head, int x) {
        ListNode lesserhead = new ListNode(0);//dummy head
        ListNode greaterhead = new ListNode(0);//dummy head;
        ListNode lesser = lesserhead;//dummy pointer
        ListNode greater = greaterhead;//dummy pointer

        while(head!=null){
            if(head.val<x){
                lesser.next = head;
                lesser = lesser.next;
            }
            else{
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        greater.next = null;
        lesser.next = greaterhead.next;
        return lesserhead.next;
        
    }
}