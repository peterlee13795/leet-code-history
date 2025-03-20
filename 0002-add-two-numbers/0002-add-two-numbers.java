class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      return sum(l1, l2, 0);
    }

    private ListNode sum(ListNode l1, ListNode l2, int initValue) {
      int sum = initValue;
      if (l1 != null) {
        sum += l1.val;
      }
      if (l2 != null) {
        sum += l2.val;
      }

      boolean nextExtra = sum / 10 > 0;
      int val = sum % 10;

      ListNode node = new ListNode(val);
      boolean l1Next = l1 != null && l1.next != null;
      boolean l2Next = l2 != null && l2.next != null;
      if (l1Next || l2Next) {
        node.next = sum(l1 != null ? l1.next : null, l2 != null ? l2.next : null, nextExtra ? 1 : 0);
      } else if (nextExtra) {
        node.next = sum(null, null, 1);
      }

      return node;
    }


  }