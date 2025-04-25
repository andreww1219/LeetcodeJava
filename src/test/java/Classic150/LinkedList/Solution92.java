package Classic150.LinkedList;


// 反转链表II
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int offset = 1;
        ListNode dummy = new ListNode(0, head);
        ListNode start = dummy, cur = head;
        while (offset < left) {
            start = cur;
            cur = cur.next;
            offset++;
        }
        ListNode end = cur;
        ListNode pre = null;
        while (offset < right + 1) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            offset++;
        }
        start.next = pre;
        end.next = cur;
        return dummy.next;
    }
}
