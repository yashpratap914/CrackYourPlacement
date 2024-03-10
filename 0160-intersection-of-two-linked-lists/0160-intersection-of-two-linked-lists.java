/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int sizeA=0, sizeB=0,d;
        
        while(tempA!=null){
            sizeA++;
            tempA=tempA.next;
        }
        while(tempB!=null){
            sizeB++;
            tempB=tempB.next;
        }
        tempA=headA;
        tempB = headB;
        if(sizeA>sizeB){           
            d=sizeA-sizeB;
            for(int i=0; i<d; i++){
                tempA=tempA.next;
            }
        }
        else{            
            d=sizeB-sizeA;
            for(int i=0; i<d; i++){
                tempB = tempB.next;
            }
        }
        
        while(tempA!=tempB){
            
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return tempA;
        
    }
}