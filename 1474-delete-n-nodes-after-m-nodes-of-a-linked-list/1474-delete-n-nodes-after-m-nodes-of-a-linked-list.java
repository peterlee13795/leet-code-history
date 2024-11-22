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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        // m개 유지, n개 삭제
        ListNode last = null;

        ListNode now = head;
        int remain = 0, delete = 0;
        while (now != null) {
            if(last == null) { // remain
                if(++remain == m) {
                    last = now;
                    now = last.next;
                    last.next = null;
                    remain = 0;
                    continue;
                }
            } else { // delete
                if(++delete == n) {
                    last.next = now.next;
                    last = null;
                    delete = 0;
                }
            }
            now = now.next;
        }
        return head;
    }
}