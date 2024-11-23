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
    public ListNode plusOne(ListNode head) {
        // 최상단 head
        ListNode topHead = new ListNode(0);

        ListNode target = head;
        ListNode notNine = head; // 9가 아닌 가장 오른쪽 노드
        while (target != null) {
            if(target.val != 9) notNine = target; // 가장 오른쪽의 8 이하
            target = target.next; // 다음 노드 이동
        }

        if(notNine == head && head.val == 9) { // 최상단이고 9 라면
            notNine = topHead; // 1단계 추가
            topHead.next = head;
            head = topHead;
        }

        notNine.val++; // plus one
        target = notNine.next;

        while(target != null) {
            target.val = 0;
            target = target.next;
        }
        return head;
    }
}