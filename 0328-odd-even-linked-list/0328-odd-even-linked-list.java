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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;


        Queue<ListNode> forward = new LinkedList<>();
        Queue<ListNode> backward = new LinkedList<>();

        ListNode node = head;
        int index = 1;
        while(node != null) {
            if(index++ % 2 == 1) {
                forward.add(node);
            } else {
                backward.add(node);
            }
            node = node.next;
        }
        ListNode forwardNode0 = forward.poll();
        forwardNode0.next = null;
        while(!forward.isEmpty()) {
            ListNode nextNode = forward.poll();
            nextNode.next = null;
            forwardNode0.next = nextNode;
            forwardNode0 = nextNode;
        }
        ListNode backwardNode0 = backward.poll();
        backwardNode0.next = null;
        forwardNode0.next = backwardNode0;
        while(!backward.isEmpty()) {
            ListNode nextNode = backward.poll();
            nextNode.next = null;
            backwardNode0.next = nextNode;
            backwardNode0 = nextNode;
        }

        return head;
    }
}