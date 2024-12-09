package Hot100.LinkedList;

// 排序链表
public class Solution148 {
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0, null);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) cur.next = head1;
        if (head2 != null) cur.next = head2;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {node = node.next; ++len;}
        ListNode dummy = new ListNode(0, head);
        for (int gap = 1; gap < len; gap *= 2) {
            ListNode pre = dummy, cur = dummy.next;
            while (cur != null) {
                ListNode next = null;
                // 截断得到两个长为gap的链表
                ListNode head1 = cur;
                for (int i = 1; i < gap && cur.next != null; ++i) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < gap && cur != null && cur.next != null; ++i) {
                    cur = cur.next;
                }
                if (cur != null) {next = cur.next; cur.next = null;}
                // 将前后链表相接
                pre.next = merge(head1, head2);
                while (pre.next != null) pre = pre.next;
                cur = next;
            }
        }
        return dummy.next;
    }
}
