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
    int inc = 0, expected = 0;
    ListNode delete;
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        
        dfs(head);
        return head;
    }
    
    private void dfs(ListNode node) {
        inc++;
        if(node.next != null) { // middle
            dfs(node.next);
        } else { // tail
            expected = (inc / 2) + 1;
        }
        if(delete != null) {
            node.next = delete.next;
            delete = null;
        }
        if(expected == inc) {
            delete = node;
        }
        inc--;
        
    }
}