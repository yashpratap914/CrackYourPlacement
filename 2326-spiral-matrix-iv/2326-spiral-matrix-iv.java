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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int[] r : res) {
            Arrays.fill(r, -1);
        }

        ListNode curr = head;

        int rowBegin = 0, rowEnd = m - 1;
        int colBegin = 0, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd && curr != null) {
            // left to right
            for (int i = colBegin; i <= colEnd && curr != null; i++) {
                if (curr != null) {
                    res[rowBegin][i] = curr.val;
                }
                curr = curr.next;
            }
            rowBegin++;

            // top to button
            for (int i = rowBegin; i <= rowEnd && curr != null; i++) {
                if (curr != null) {
                    res[i][colEnd] = curr.val;
                }
                curr = curr.next;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin && curr != null; i--) {
                    if (curr != null) {
                        res[rowEnd][i] = curr.val;
                    }
                    curr = curr.next;
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin && curr != null; i--) {
                    if (curr != null) {
                        res[i][colBegin] = curr.val;
                    }
                    curr = curr.next;
                }
            }
            colBegin++;
        }
        return res;
        
    }
}