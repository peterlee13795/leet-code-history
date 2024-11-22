/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int val) {
        Node node = new Node(val);
        if(head == null) {
            node.next = node;
            return node;
        }
        if(head.next == null || head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node current = head;
        while(true) {
            int val0 = current.val;
            int val1 = current.next.val;
            boolean sort = val0 < val1 && val > val0 && val <= val1;
            boolean first = val0 > val1 && val < val0 && val <= val1;
            boolean last = val0 > val1 && val > val0 && val >= val1;
            if(sort || first || last) {
                node.next = current.next;
                current.next = node;
                break;
            }
            if(head == current.next) {
                node.next = current.next;
                current.next = node;
                break;
            }
            current = current.next;
        }
        return head;
    }
}