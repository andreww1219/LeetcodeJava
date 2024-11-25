package Hot100.LinkedList;


// 环形链表
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) return true;
        }
        return false;
    }
}
