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
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        ListNode leftPrev = null, rightNext = null;;
        ListNode leftNode = null, rightNode = null;
        int count = 1;
        while(temp != null) {
            if(count == left) {
                leftNode = temp;
            }
            else if(count == right && leftNode != null) {
                rightNode = temp;
                rightNext = temp.next;
                rightNode.next = null;
                ListNode reversed_head = reverse(leftNode);
                if(leftPrev != null)
                    leftPrev.next = reversed_head;
                else
                    head = reversed_head;
                leftNode.next = rightNext;
                break;
            }
            if(leftNode == null)
                leftPrev = temp;
            temp = temp.next;
            count += 1;
        }

        return head;
    }
}