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
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean set[] = new boolean[(int)1e5+1];
        for(int num : nums){
            set[num] = true; 
        }
        ListNode prev = null;
        ListNode temp = head;
        while(temp!=null){
            if(set[temp.val]==true){
                if(prev == null){ // del at head
                    head= head.next;
                    temp.next = null;
                    temp=head;
                }
                else{
                    prev.next = temp.next;
                    temp.next = null;
                    temp = prev.next;
                }
            }
            else{
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}