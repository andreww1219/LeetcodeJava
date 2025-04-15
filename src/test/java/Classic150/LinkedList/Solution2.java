package Classic150.LinkedList;


// 两数相加
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        ListNode cur1 = l1, cur2 = l2;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null || l2 != null) {
            if (l1 != null) cur.next = l1;
            if (l2 != null) cur.next = l2;
        }
        while (carry != 0) {
            if (cur.next == null) {
                cur.next = new ListNode(1);
                break;
            } else {
              int val = cur.next.val + 1;
              carry = val / 10;
              cur.next.val = val % 10;
              cur = cur.next;
            }
        }
        return dummy.next;
    }
}
