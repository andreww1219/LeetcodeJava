package Hot100.LinkedList;


// 两数相加
public class Solution2 {
    // 初见
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dumpNode = new ListNode(0);
        ListNode cur = dumpNode;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            l2 = l2.next;
            cur = cur.next;
        }
        if (carry > 0) cur.next = new ListNode(carry);
        return dumpNode.next;
    }
    // 漂亮题解
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dumpNode = new ListNode(0);
        ListNode cur = dumpNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            cur = cur.next;
        }
        return dumpNode.next;
    }
}
