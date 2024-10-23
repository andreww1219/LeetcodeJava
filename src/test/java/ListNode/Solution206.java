package ListNode;

// 反转链表
public class Solution206 {

    // 标准题解 时间复杂度 O(n) 空间复杂度 O(1)
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 递归题解 时间复杂度 O(n) 空间复杂度 O(n)
    private ListNode reverse(ListNode pre, ListNode cur){
        if (cur == null)
            return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }
}
