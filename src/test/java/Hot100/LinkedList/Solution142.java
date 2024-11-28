package Hot100.LinkedList;


// 环形链表II
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, quick = head;
        int n = 0;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            ++n;
            if (quick == slow) break;
        }
        if (quick == null || quick.next == null) return null;
        slow = head;
        quick = head;
        for (int i = 0; i < n; i++) quick = quick.next;
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }
        return quick;
    }
}
