package Hot100.LinkedList;


// 删除链表的倒数第N个结点
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, quick = dummy;
        for (int i = 0; i < n + 1; ++i)
            quick = quick.next;
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
