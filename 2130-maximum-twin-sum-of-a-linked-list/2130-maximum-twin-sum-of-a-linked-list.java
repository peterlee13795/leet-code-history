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
    int max = 0;
    List<Integer> list = new ArrayList<>();
    public int pairSum(ListNode head) {
        dfs(head);
        int max = 0;
        int len = list.size();
        int count = len / 2;
        for(int i0 =0, i1 = len - 1; i0 < count; i0++, i1--) {
            max = Math.max(max, list.get(i0) + list.get(i1));
        }
        
        return max;
    }
    
    private void dfs(ListNode node) {
        list.add(node.val);
        if(node.next != null) dfs(node.next);
    }
}