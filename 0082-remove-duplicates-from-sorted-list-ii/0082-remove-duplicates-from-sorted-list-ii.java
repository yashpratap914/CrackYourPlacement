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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy= new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode temp=head;
        while(temp!=null){
            if(temp.next!=null && temp.val==temp.next.val){

                while(temp.next!=null && temp.val==temp.next.val){ // to skip the duplicates
                    temp=temp.next;
                } // now temp is at last duplicate val
                prev.next=temp.next;
        }
        else{
            prev=prev.next; // if no duplicate at the temp then move the prev pointer
        }
           temp=temp.next; // move the temp pointer
        }
        return dummy.next;
        
    }
}